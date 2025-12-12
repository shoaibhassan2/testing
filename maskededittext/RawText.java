package pk.gov.nadra.maskededittext;

/* loaded from: classes5.dex */
public class RawText {
    private String text = "";

    public void subtractFromString(Range range) {
        String strSubstring = "";
        String strSubstring2 = (range.getStart() <= 0 || range.getStart() > this.text.length()) ? "" : this.text.substring(0, range.getStart());
        if (range.getEnd() >= 0 && range.getEnd() < this.text.length()) {
            strSubstring = this.text.substring(range.getEnd(), this.text.length());
        }
        this.text = strSubstring2.concat(strSubstring);
    }

    public int addToString(String newString, int start, int maxLength) {
        String strSubstring;
        if (newString != null) {
            String strSubstring2 = "";
            if (!newString.equals("")) {
                if (start < 0) {
                    throw new IllegalArgumentException("Start position must be non-negative");
                }
                if (start > this.text.length()) {
                    throw new IllegalArgumentException("Start position must be less than the actual text length");
                }
                int length = newString.length();
                if (start <= 0) {
                    strSubstring = "";
                } else {
                    strSubstring = this.text.substring(0, start);
                }
                if (start >= 0 && start < this.text.length()) {
                    String str = this.text;
                    strSubstring2 = str.substring(start, str.length());
                }
                if (this.text.length() + newString.length() > maxLength) {
                    length = maxLength - this.text.length();
                    newString = newString.substring(0, length);
                }
                this.text = strSubstring.concat(newString).concat(strSubstring2);
                return length;
            }
        }
        return 0;
    }

    public String getText() {
        return this.text;
    }

    public int length() {
        return this.text.length();
    }

    public char charAt(int position) {
        return this.text.charAt(position);
    }
}