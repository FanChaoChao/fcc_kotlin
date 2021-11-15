package com.example.lesson

import com.example.core.http.HttpClient.get
import com.example.core.utils.toast
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken
import com.example.lesson.LessonPresenter
import com.example.core.http.EntityCallback
import java.util.ArrayList

class LessonPresenter {
    companion object {
        private const val LESSON_PATH = "lessons"
    }
    private var activity:LessonActivity? = null
    private var lessons: List<Lesson> = ArrayList()
    private val type = object : TypeToken<List<Lesson?>?>() {}.type

    constructor(activity: LessonActivity?){
        this.activity = activity
    }

    fun fetchData() {
        get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {

            override fun onSuccess(lessons: List<Lesson>) {
                this@LessonPresenter.lessons = lessons
                activity!!.runOnUiThread { activity!!.showResult(lessons) }
            }

            override fun onFailure(message: String) {
                activity!!.runOnUiThread { toast(message!!) }
            }
        })
    }

    fun showPlayback() {
        val playbackLessons = arrayListOf<Lesson>()
        for (lesson in lessons) {
            if (lesson.state === Lesson.State.PLAYBACK) {
                playbackLessons.add(lesson)
            }
        }
        activity!!.showResult(playbackLessons)
    }


}