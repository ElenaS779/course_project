package utils;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.JavascriptExecutor;

public class Helper {
    public static void scroll(String elementId) {
        Selenide.executeJavaScript(String.format("function Position(obj){\n" +
                " var currenttop = 0;\n" +
                " if (obj.offsetParent){\n" +
                "  do {\n" +
                "   currenttop += obj.offsetTop;\n" +
                " }while ((obj = obj.offsetParent));\n" +
                "  return [currenttop];\n" +
                " }\n" +
                "}\n" +
                "window.scrollTo(0, Position(document.getElementById(\"%s\")))", elementId), "");
    }

    public static void scrollToXPath(String xpath) {
        Selenide.executeJavaScript(String.format("function Position(obj){\n" +
                " var currenttop = 0;\n" +
                " if (obj.offsetParent){\n" +
                "  do {\n" +
                "   currenttop += obj.offsetTop;\n" +
                " }while ((obj = obj.offsetParent));\n" +
                "  return [currenttop];\n" +
                " }\n" +
                "}\n" +
                "window.scrollTo(0, Position(document.evaluate('%s', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue))", xpath), "");
    }
}
