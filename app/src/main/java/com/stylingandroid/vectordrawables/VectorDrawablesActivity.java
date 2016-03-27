package com.stylingandroid.vectordrawables;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class VectorDrawablesActivity extends ActionBarActivity {

    // These lines set the log method in the JavaScript
    // Any Java classes or methods can be accessed with **Packages** prefix
    private static final String RHINO_LOG = "var log = Packages.com.stylingandroid.vectordrawables.VectorDrawablesActivity.log;";

    public static void log(String msg) {
        Log.i("Default", msg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector_drawables);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(ImagePagerAdapter.newInstance(this));

//        Duktape duktape = Duktape.create();
//        try {
//            // Log.d("Default", duktape.evaluate("'hello world'.toUpperCase();"));
//            String script = "new Java.type(\"java.util.ArrayList\")";
//            String o = duktape.evaluate(script);
//            Log.d("Default", "JS=" + o);
//
//        } finally {
//            duktape.close();
//        }
        runRhino();
    }

    //    private void runRhino() {
//        String script = "function hello(java) {\n" +
//                "    if (typeof log != 'undefined') {\n" +
//                "        log(\"JavaScript say hello to \" + java);\n" +
//                "\n" +
//                "        log(\"Also, I can access Java object: \" + javaContext);\n" +
//                "    }\n" +
//                "\n" +
//                "    return { foo: \"bar in JavaScript\" };\n" +
//                "}";
//
//        // Get the JavaScript in previous section
//        String source = script;
//        String functionName = "hello";
//        Object[] functionParams = new Object[]{"Android"};
//
//        // Every Rhino VM begins with the enter()
//        // This Context is not Android's Context
//        Context rhino = Context.enter();
//
//        // Turn off optimization to make Rhino Android compatible
//        rhino.setOptimizationLevel(-1);
//        try {
//            Scriptable scope = rhino.initStandardObjects();
//
//            // This line set the javaContext variable in JavaScript
//            // ScriptableObject.putProperty(scope, "javaContext", Context.javaToJS(androidContextObject, scope));
//            ScriptableObject.putProperty(scope, "javaContext", Context.javaToJS(this, scope));
//
//            // Note the forth argument is 1, which means the JavaScript source has
//            // been compressed to only one line using something like YUI
//            // rhino.evaluateString(scope, RHINO_LOG + source, "ScriptAPI", 1, null);
//            rhino.evaluateString(scope, RHINO_LOG + source, "VectorDrawablesActivity", 1, null);
//
//            // We get the hello function defined in JavaScript
//            Function function = (Function) scope.get(functionName, scope);
//
//            // Call the hello function with params
//            NativeObject result = (NativeObject) function.call(rhino, scope, scope, functionParams);
//            // After the hello function is invoked, you will see logcat output
//
//            // Finally we want to print the result of hello function
//            String foo = (String) Context.jsToJava(result.get("foo", result), String.class);
//            log(foo);
//        } finally {
//            // We must exit the Rhino VM
//            Context.exit();
//        }
//    }
    private void runRhino() {
        // OMG IT WORKS
        String script = "function run(androidContext) {\n" +
                "\t// Imports\n" +
                "\tvar NotifUtils = Packages.com.stylingandroid.vectordrawables.NotifUtils;\n" +
                "\n" +
                "\t// Actual code\n" +
                "\tvar title = \"My title\"\n" +
                "\tNotifUtils.launch(androidContext, title);\n" +
                "}";
//    String script = "function run(androidContext) {\n" +
//            "\tvar FooActivity = Packages.com.stylingandroid.vectordrawables.FooActivity;\n" +
//            "\tvar Intent = Packages.android.content.Intent;\n" +
//            "\n" +
//            "\tvar intent = new Intent(androidContext, FooActivity);\n" +
//            "        androidContext.startActivity(intent);\n" +
//            "}";

        // Get the JavaScript in previous section
        String functionName = "run";
        Object[] functionParams = new Object[]{this};

        // Every Rhino VM begins with the enter()
        // This Context is not Android's Context
        Context rhino = Context.enter();

        // Turn off optimization to make Rhino Android compatible
        rhino.setOptimizationLevel(-1);
        try {
            Scriptable scope = rhino.initStandardObjects();

            // This line set the javaContext variable in JavaScript
            ScriptableObject.putProperty(scope, "javaContext", Context.javaToJS(this, scope));

            // Note the forth argument is 1, which means the JavaScript source has
            // been compressed to only one line using something like YUI
            rhino.evaluateString(scope, script, "whatever", 1, null);

            // We get the hello function defined in JavaScript
            Function function = (Function) scope.get(functionName, scope);

            // Call the hello function with params
            function.call(rhino, scope, scope, functionParams);

        } finally {
            // We must exit the Rhino VM
            Context.exit();
        }
    }
}
