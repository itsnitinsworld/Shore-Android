package com.theshoremedia.modules.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.theshoremedia.utils.AppConstants

/**
 * @author- Nitin Khanna
 * @date -
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }


    abstract fun loadFragment(
        fragment: Fragment,
        title: String? = null,
        addToBackStack: Boolean = true,
        animateFragment: Boolean = true,
        toAddOrReplace: Int= AppConstants.FragmentConstants.ADD
    )

    fun clearBackStack(appCompatActivity: AppCompatActivity) {
        val manager = appCompatActivity.supportFragmentManager
        if (manager.backStackEntryCount > 1) {
            val first = manager.getBackStackEntryAt(1)
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

}