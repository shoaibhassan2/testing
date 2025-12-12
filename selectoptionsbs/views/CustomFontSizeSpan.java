package pk.gov.nadra.selectoptionsbs.views;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomFontSizeSpan.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0012"}, d2 = {"Lpk/gov/nadra/selectoptionsbs/views/CustomFontSizeSpan;", "Landroid/text/style/MetricAffectingSpan;", "context", "Landroid/content/Context;", "typeface", "Landroid/graphics/Typeface;", "textSizeRes", "", "<init>", "(Landroid/content/Context;Landroid/graphics/Typeface;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "updateDrawState", "", "tp", "Landroid/text/TextPaint;", "updateMeasureState", "apply", "paint", "OptionPickerBS_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CustomFontSizeSpan extends MetricAffectingSpan {
    private final Context context;
    private final Integer textSizeRes;
    private final Typeface typeface;

    public /* synthetic */ CustomFontSizeSpan(Context context, Typeface typeface, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, typeface, (i & 4) != 0 ? null : num);
    }

    public CustomFontSizeSpan(Context context, Typeface typeface, Integer num) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        this.context = context;
        this.typeface = typeface;
        this.textSizeRes = num;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        apply(tp);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        apply(tp);
    }

    private final void apply(TextPaint paint) {
        Typeface typeface = paint.getTypeface();
        int style = (typeface != null ? typeface.getStyle() : 0) & (~this.typeface.getStyle());
        if ((style & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((style & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(this.typeface);
        Integer num = this.textSizeRes;
        if (num != null) {
            paint.setTextSize(this.context.getResources().getDimension(num.intValue()));
        }
    }
}