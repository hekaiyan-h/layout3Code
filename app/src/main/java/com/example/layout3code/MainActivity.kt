package com.example.layout3code

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        addLinearLayout()
    }

    fun dpTopx(dp: Int): Int{
        return (resources.displayMetrics.density * dp).toInt()
    }

    private fun addLinearLayout(){
        //1. 创建LinearLayout的容器
        val container = LinearLayout(this).apply {
            //2. 设置宽、高
            layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT)
            //3. 设置布局方向
            orientation = LinearLayout.VERTICAL
            // 设置背景色
            background = getDrawable(R.color.colorPrimary)
        }.also { setContentView(it) }

        //创建第一个子控件 为横向布局的LinearLayout
        LinearLayout(this).apply {
                //2.设置宽、高
                layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        dpTopx(100))
                //3.设置布局方向
                orientation = LinearLayout.HORIZONTAL
                //设置背景色
                background = getDrawable(R.color.colorPrimaryDark)
                //4.将当前子控件添加到父容器中
                container.addView(this)
        }.apply {
            // 图片
            ImageView(this@MainActivity).apply {
                layoutParams = LinearLayout.LayoutParams(
                        dpTopx(100),LinearLayout.LayoutParams.MATCH_PARENT).apply {
                    setMargins(dpTopx(10),dpTopx(10),dpTopx(10),dpTopx(10))
                }
                //加入的图片资源
                setImageResource(R.drawable.sl)
                //设置图片填充模式
                scaleType = ImageView.ScaleType.CENTER_CROP
                //将当前图片添加到父容器中
                addView(this)
            }
            // 文字
            TextView(this@MainActivity).apply {
                //设置宽、高
                layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT).apply {
                    setMargins(dpTopx(10),dpTopx(10),dpTopx(10),dpTopx(10))
                }
                text = "浙江高考满分作文被指晦涩难懂，阅卷组长：得分“恰如其分”"
                //设置字体颜色
                setTextColor(getColor(R.color.colorWhite))
                //设置字体大小
                textSize = 20f
                //将当前控件加入到父容器中
                addView(this)
            }
        }

        // 创建第二个子控件 TextVie
        TextView(this).apply {
            // 1.设置宽、高
            layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT).apply {
                setMargins(dpTopx(10),dpTopx(10),dpTopx(10),dpTopx(10))
            }
            text = "新京报讯（记者 刘名洋 实习生 王健）因为大量引用冷门的名人名言和冷僻字词，浙江高考满分作文《生活在树上》对外公布后，引发舆论争议。\n" +
                    "\n" +
                    "浙江高考作文阅卷大组组长陈建新称，上述文章经过三次打分，最终阅卷组决定给出满分的成绩。关于争议，陈建新表示，尽管存在晦涩和难懂的情况，也不希望学生模仿，不过其仍然认为，这篇文章所获得的分数“恰如其分”。\n" +
                    "\n" +
                    "3日下午，浙江省教育考试院工作人员表示，已介入处理上述作文评分事宜。"
            setTextColor(getColor(R.color.colorWhite))
            textSize = 20f
            //2. 将当前控件添加到父容器上
            container.addView(this)
        }
    }


}