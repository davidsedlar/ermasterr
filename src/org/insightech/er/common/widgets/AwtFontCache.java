package org.insightech.er.common.widgets;

import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

public class AwtFontCache {

    private static final Map<String, Font> fontCache = new HashMap<String, Font>();

    private static boolean initialized = false;

    public static void initialize() {
        if (initialized) {
            return;
        }

        if (Display.getCurrent() != null) {
            final FontData fontData = Display.getCurrent().getSystemFont().getFontData()[0];
            cacheFont(fontData.getName(), Font.PLAIN, 12);
            cacheFont(fontData.getName(), Font.PLAIN, 8);
            initialized = true;
        }
    }

    private static void cacheFont(final String fontName, final int style, final int size) {
        final String key = fontName + "_" + style + "_" + size;
        if (!fontCache.containsKey(key)) {
            final Font font = new Font(fontName, style, size);
            fontCache.put(key, font);
        }
    }

    public static Font getFont(final String fontName, final int style, final int size) {
        final String key = fontName + "_" + style + "_" + size;
        Font font = fontCache.get(key);

        if (font == null) {
            font = new Font(fontName, style, size);
            fontCache.put(key, font);
        }

        return font;
    }

    public static Font getSystemFont() {
        return getFont("SansSerif", Font.PLAIN, 12);
    }

    public static Font getSystemFont(final int size) {
        return getFont("SansSerif", Font.PLAIN, size);
    }
}
