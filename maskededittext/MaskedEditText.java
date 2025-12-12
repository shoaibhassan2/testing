package pk.gov.nadra.maskededittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.apache.commons.lang3.StringUtils;
import pk.gov.nadra.rahbar.android.R;

/* loaded from: classes5.dex */
public class MaskedEditText extends EditText implements TextWatcher {
    private char charRepresentation;
    private char[] charsInMask;
    private boolean editingAfter;
    private boolean editingBefore;
    private boolean editingOnChanged;
    private View.OnFocusChangeListener focusChangeListener;
    private boolean ignore;
    private boolean initialized;
    private int lastValidMaskPosition;
    private String mask;
    private char maskFill;
    private int[] maskToRaw;
    protected int maxRawLength;
    private RawText rawText;
    private int[] rawToMask;
    private int selection;
    private boolean selectionChanged;

    public MaskedEditText(Context context) {
        super(context);
        init();
    }

    public MaskedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.MaskedEditText);
        this.mask = typedArrayObtainStyledAttributes.getString(R.styleable.MaskedEditText_mask);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.MaskedEditText_mask_fill);
        this.maskFill = (string == null || string.length() <= 0) ? ' ' : string.charAt(0);
        String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.MaskedEditText_char_representation);
        if (string2 == null) {
            this.charRepresentation = '#';
        } else {
            this.charRepresentation = string2.charAt(0);
        }
        cleanUp();
        setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: pk.gov.nadra.maskededittext.MaskedEditText.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return actionId != 5;
            }
        });
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener listener) {
        this.focusChangeListener = listener;
    }

    private void cleanUp() {
        if (this.mask == null) {
            return;
        }
        this.initialized = false;
        generatePositionArrays();
        this.rawText = new RawText();
        this.selection = this.rawToMask[0];
        this.editingBefore = true;
        this.editingOnChanged = true;
        this.editingAfter = true;
        if (hasHint()) {
            setText((CharSequence) null);
        } else {
            setText(this.mask.replace(this.charRepresentation, this.maskFill));
        }
        this.editingBefore = false;
        this.editingOnChanged = false;
        this.editingAfter = false;
        this.maxRawLength = this.maskToRaw[previousValidPosition(this.mask.length() - 1)] + 1;
        this.lastValidMaskPosition = findLastValidMaskPosition();
        this.initialized = true;
        super.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: pk.gov.nadra.maskededittext.MaskedEditText.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View v, boolean hasFocus) {
                if (MaskedEditText.this.focusChangeListener != null) {
                    MaskedEditText.this.focusChangeListener.onFocusChange(v, hasFocus);
                }
                if (MaskedEditText.this.hasFocus()) {
                    if (MaskedEditText.this.rawText.length() > 0 || !MaskedEditText.this.hasHint()) {
                        MaskedEditText.this.selectionChanged = false;
                        MaskedEditText maskedEditText = MaskedEditText.this;
                        maskedEditText.setSelection(maskedEditText.lastValidPosition());
                    }
                }
            }
        });
    }

    private int findLastValidMaskPosition() {
        for (int length = this.maskToRaw.length - 1; length >= 0; length--) {
            if (this.maskToRaw[length] != -1) {
                return length;
            }
        }
        throw new RuntimeException("Mask contains only the representation char");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasHint() {
        return getHint() != null;
    }

    public MaskedEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void setMask(String mask) {
        this.mask = mask;
        cleanUp();
    }

    public String getMask() {
        return this.mask;
    }

    public void setCharRepresentation(char charRepresentation) {
        this.charRepresentation = charRepresentation;
        cleanUp();
    }

    public char getCharRepresentation() {
        return this.charRepresentation;
    }

    private void generatePositionArrays() {
        int[] iArr = new int[this.mask.length()];
        this.maskToRaw = new int[this.mask.length()];
        String strConcat = "";
        int i = 0;
        for (int i2 = 0; i2 < this.mask.length(); i2++) {
            char cCharAt = this.mask.charAt(i2);
            if (cCharAt == this.charRepresentation) {
                iArr[i] = i2;
                this.maskToRaw[i2] = i;
                i++;
            } else {
                String string = Character.toString(cCharAt);
                if (!strConcat.contains(string) && !Character.isLetter(cCharAt) && !Character.isDigit(cCharAt)) {
                    strConcat = strConcat.concat(string);
                }
                this.maskToRaw[i2] = -1;
            }
        }
        if (strConcat.indexOf(32) < 0) {
            strConcat = strConcat + StringUtils.SPACE;
        }
        this.charsInMask = strConcat.toCharArray();
        this.rawToMask = new int[i];
        for (int i3 = 0; i3 < i; i3++) {
            this.rawToMask[i3] = iArr[i3];
        }
    }

    private void init() {
        addTextChangedListener(this);
        setInputType(2);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        if (this.mask == null || this.editingBefore) {
            return;
        }
        this.editingBefore = true;
        if (start > this.lastValidMaskPosition) {
            this.ignore = true;
        }
        Range rangeCalculateRange = calculateRange(after == 0 ? erasingStart(start) : start, start + count);
        if (rangeCalculateRange.getStart() != -1) {
            this.rawText.subtractFromString(rangeCalculateRange);
        }
        if (count > 0) {
            this.selection = previousValidPosition(start);
        }
    }

    private int erasingStart(int start) {
        while (start > 0 && this.maskToRaw[start] == -1) {
            start--;
        }
        return start;
    }

    @Override // android.widget.TextView, android.text.TextWatcher
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        int i;
        if (this.mask == null || this.editingOnChanged || !this.editingBefore) {
            return;
        }
        this.editingOnChanged = true;
        if (!this.ignore && count > 0) {
            int i2 = this.maskToRaw[nextValidPosition(start)];
            int iAddToString = this.rawText.addToString(clear(s.subSequence(start, count + start).toString()), i2, this.maxRawLength);
            if (this.initialized) {
                int i3 = i2 + iAddToString;
                int[] iArr = this.rawToMask;
                if (i3 < iArr.length) {
                    i = iArr[i3];
                } else {
                    i = this.lastValidMaskPosition + 1;
                }
                this.selection = nextValidPosition(i);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s) {
        if (this.mask != null && !this.editingAfter && this.editingBefore && this.editingOnChanged) {
            this.editingAfter = true;
            if (this.rawText.length() == 0 && hasHint()) {
                this.selection = 0;
                setText((CharSequence) null);
            } else {
                setText(makeMaskedText());
            }
            this.selectionChanged = false;
            setSelection(this.selection);
            this.editingBefore = false;
            this.editingOnChanged = false;
            this.editingAfter = false;
            this.ignore = false;
        }
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int selStart, int selEnd) {
        if (this.mask == null) {
            super.onSelectionChanged(selStart, selEnd);
            return;
        }
        if (this.initialized) {
            if (!this.selectionChanged) {
                if (this.rawText.length() == 0 && hasHint()) {
                    selStart = 0;
                    selEnd = 0;
                } else {
                    selStart = fixSelection(selStart);
                    selEnd = fixSelection(selEnd);
                }
                setSelection(selStart, selEnd);
                this.selectionChanged = true;
            } else if ((!hasHint() || this.rawText.length() != 0) && selStart > this.rawText.length() - 1) {
                setSelection(fixSelection(selStart), fixSelection(selEnd));
            }
        }
        super.onSelectionChanged(selStart, selEnd);
    }

    private int fixSelection(int selection) {
        if (selection > lastValidPosition()) {
            return lastValidPosition();
        }
        return nextValidPosition(selection);
    }

    private int nextValidPosition(int currentPosition) {
        int i;
        while (true) {
            i = this.lastValidMaskPosition;
            if (currentPosition >= i || this.maskToRaw[currentPosition] != -1) {
                break;
            }
            currentPosition++;
        }
        return currentPosition > i ? i + 1 : currentPosition;
    }

    private int previousValidPosition(int currentPosition) {
        while (currentPosition >= 0 && this.maskToRaw[currentPosition] == -1) {
            currentPosition--;
            if (currentPosition < 0) {
                return nextValidPosition(0);
            }
        }
        return currentPosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lastValidPosition() {
        if (this.rawText.length() == this.maxRawLength) {
            return this.rawToMask[this.rawText.length() - 1] + 1;
        }
        return nextValidPosition(this.rawToMask[this.rawText.length()]);
    }

    private String makeMaskedText() {
        char[] charArray = this.mask.replace(this.charRepresentation, ' ').toCharArray();
        for (int i = 0; i < this.rawToMask.length; i++) {
            if (i < this.rawText.length()) {
                charArray[this.rawToMask[i]] = this.rawText.charAt(i);
            } else {
                charArray[this.rawToMask[i]] = this.maskFill;
            }
        }
        return new String(charArray);
    }

    private Range calculateRange(int start, int end) {
        int iPreviousValidPosition;
        Range range = new Range();
        for (int i = start; i <= end && i < this.mask.length(); i++) {
            if (this.maskToRaw[i] != -1) {
                if (range.getStart() == -1) {
                    range.setStart(this.maskToRaw[i]);
                }
                range.setEnd(this.maskToRaw[i]);
            }
        }
        if (end == this.mask.length()) {
            range.setEnd(this.rawText.length());
        }
        if (range.getStart() == range.getEnd() && start < end && (iPreviousValidPosition = previousValidPosition(range.getStart() - 1)) < range.getStart()) {
            range.setStart(iPreviousValidPosition);
        }
        return range;
    }

    private String clear(String string) {
        for (char c : this.charsInMask) {
            string = string.replace(Character.toString(c), "");
        }
        return string;
    }
}