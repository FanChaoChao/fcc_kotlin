package com.example.core.utils

import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast
import com.example.core.BaseApplication


private val displayMetrics = Resources.getSystem().displayMetrics;

fun Float.dp2px(): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, displayMetrics);
}

//fun toast(string: String) {
//    toast(string, Toast.LENGTH_SHORT);
//}
//通过@JvmOverloads注解使java代码调用该方法时可以重载出两个不同参数数量的方法，否则java对于kotlin中这类有默认值的函数只能识别出一个
fun toast(string: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(BaseApplication.currentApplication, string, duration).show();
}
