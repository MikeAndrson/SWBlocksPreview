package ma.swblockspreview.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class StringUtils {


    public static class StringTokenizer {
        public String a;
        public int b;

        public StringTokenizer(String var1) {
            a = var1;
            b = 0;
        }

        public boolean a() {
            return b >= a.length();
        }

        public String b() {
            c();
            boolean var1 = a();
            StringBuilder var2 = new StringBuilder();
            if (!var1) {
                boolean var3 = false;
                int var4 = b;

                while (b < a.length()) {
                    if (a.charAt(b) == 32) {
                        return var2.toString();
                    }

                    char var5 = a.charAt(b);
                    if (var5 == 92) {
                        var2.append(var5 + a.charAt(1 + b));
                        b += 2;
                    } else {
                        if (var5 == 37) {
                            if (b > var4) {
                                return var2.toString();
                            }

                            var3 = true;
                        }

                        if (var3) {
                            if (var5 == 63) {
                                break;
                            }

                            if (var5 == 45) {
                                return var2.toString();
                            }
                        }

                        String var9 = String.valueOf(var2) + var5;
                        var2 = new StringBuilder(var9);
                        ++b;
                    }
                }

            }
            return var2.toString();
        }

        public void c() {
            while (b < a.length() && a.charAt(b) == 32) {
                ++b;
            }

        }
    }


    public static int a(char var0) {
        if (var0 >= 48 && var0 <= 57) {
            return var0 - 48;
        } else {
            byte var1 = 65;
            if (var0 < var1 || var0 > 70) {
                var1 = 97;
                if (var0 < var1 || var0 > 102) {
                    String var2 = "invalid hex digit '" + var0 + "'";
                    throw new IllegalArgumentException(var2);
                }
            }

            return 10 + (var0 - var1);
        }
    }

    public static String a() {
        Random var0 = new Random();

        int var1;
        for (var1 = var0.nextInt(100000); var1 < 10000 || var1 > 99999; var1 = var0.nextInt(100000)) {
        }

        return String.valueOf(var1);
    }

    public static String a(int var0) {
        if (var0 < 0) {
            return "0";
        } else {
            float var1 = (float) var0;
            if (var1 >= 1024.0F && var1 < 1048576.0F) {
                float var7 = var1 / 1024.0F;
                return (new DecimalFormat("#.#KB")).format(var7);
            } else if (var1 >= 1048576.0F && var1 < 1.07374182E9F) {
                float var6 = var1 / 1048576.0F;
                return (new DecimalFormat("#.#MB")).format(var6);
            } else if (var1 >= 1.07374182E9F && var1 < 1.09951163E12F) {
                float var5 = var1 / 1.07374182E9F;
                return (new DecimalFormat("#.#GB")).format(var5);
            } else {
                return var0 + "B";
            }
        }
    }

    public static String a(byte[] bytes) {
        StringBuilder var1 = new StringBuilder(2 * bytes.length);

        for (byte b : bytes) {
            if ((255 & b) < 16) {
                var1.append("0");
            }

            var1.append(Long.toString(255 & b, 16));
        }

        return var1.toString();
    }

    public static void a(Context var0, String var1, String var2) {
        ((ClipboardManager) var0.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText(var1, var2));
    }

    public static byte[] a(String var0) {
        int var1 = var0.length();
        byte[] var2 = new byte[(var1 + 1) / 2];
        int var3 = var1 % 2;
        int var4 = 0;
        int var5 = 1;
        if (var3 == var5) {
            var2[0] = (byte) a(var0.charAt(0));
            var4 = 1;
        } else {
            var5 = 0;
        }

        while (var4 < var1) {
            int var6 = var5 + 1;
            int var7 = var4 + 1;
            int var8 = a(var0.charAt(var4)) << 4;
            int var9 = var7 + 1;
            var2[var5] = (byte) (var8 | a(var0.charAt(var7)));
            var5 = var6;
            var4 = var9;
        }

        return var2;
    }

    public static String b(int var0) {
        float var1 = (float) var0;
        if (var1 >= 1000.0F && var1 < 1000000.0F) {
            float var4 = var1 / 1000.0F;
            return (new DecimalFormat("#.#K")).format(var4);
        } else if (var1 >= 1000000.0F && var1 < 1.0E9F) {
            float var3 = var1 / 1000000.0F;
            return (new DecimalFormat("#.#M")).format(var3);
        } else if (var1 >= 1.0E9F && var1 < 1.0E12F) {
            float var2 = var1 / 1.0E9F;
            return (new DecimalFormat("#.#G")).format(var2);
        } else {
            return String.valueOf(var0);
        }
    }

    public static boolean b(String var0) {
        try {
            Double.parseDouble(var0);
            return true;
        } catch (NumberFormatException var1) {
            return false;
        }
    }

    public static String c(int var0) {
        return (new DecimalFormat("#,###")).format(var0);
    }

    public static ArrayList<String> c(String var0) {
        ArrayList<String> var1 = new ArrayList<>();
        StringTokenizer var2 = new StringTokenizer(var0);

        while (!var2.a()) {
            String var3 = var2.b();
            if (var3.length() > 0) {
                var1.add(var3);
            }
        }

        return var1;
    }

    public static String d(String var0) {
        StringBuilder var1 = new StringBuilder();

        for (int var2 = 0; var2 < var0.length(); ++var2) {
            char var3 = var0.charAt(var2);
            if (var3 == 92) {
                StringBuilder var4 = new StringBuilder();
                var4.append(var1);
                ++var2;
                var4.append(var0.charAt(var2));
                var1 = new StringBuilder(var4.toString());
            } else {
                var1.append(var3);
            }
        }

        return var1.toString();
    }
}
