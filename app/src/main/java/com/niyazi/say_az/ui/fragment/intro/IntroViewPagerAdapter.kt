package com.niyazi.say_az.ui.fragment.intro

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.niyazi.say_az.R
import com.niyazi.say_az.utils.INTRO_BODY
import com.niyazi.say_az.utils.INTRO_IMG
import com.niyazi.say_az.utils.INTRO_TITLE_ID

/**
 * Created by Niyazi on 12/18/2020.
 */
class IntroViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    val listOfFragment = listOf<Fragment>(
        IntroChildFragment().apply {
            arguments = bundleOf(
                INTRO_IMG to R.drawable.ic_intro_1,
                INTRO_TITLE_ID to R.string.msg_new_and_simple,
                INTRO_BODY to "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Hendrerit cras dignissim amet sit in arcu ullamcorper ultricies. "
            )
        },
        IntroChildFragment().apply {
            arguments = bundleOf(
                INTRO_IMG to R.drawable.ic_intro_2,
                INTRO_TITLE_ID to R.string.msg_useful,
                INTRO_BODY to "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Hendrerit cras dignissim amet sit in arcu ullamcorper ultricies. "
            )
        },
        IntroChildFragment().apply {
            arguments = bundleOf(
                INTRO_IMG to R.drawable.ic_intro_3,
                INTRO_TITLE_ID to R.string.msg_efficient,
                INTRO_BODY to "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Hendrerit cras dignissim amet sit in arcu ullamcorper ultricies. "
            )
        }
    )

    override fun getItemCount(): Int {
        return listOfFragment.size
    }

    override fun createFragment(position: Int): Fragment {
        return listOfFragment[position]
    }

}