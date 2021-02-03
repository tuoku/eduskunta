package com.tuoku.parliament

import android.content.DialogInterface
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.updateLayoutParams
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tuoku.parliament.databinding.FragmentMemberBinding
import com.tuoku.parliament.models.ParliamentMember

class MemberFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMemberBinding
    private var mMember: ParliamentMember? = null
    var likes = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.MyBottomSheetDialogTheme)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_member, container, false
        )

        mMember?.let {
            binding.apply {
                member = mMember
                invalidateAll()
            }
        }

        binding.fabLike.setOnClickListener {
            likes++
            binding.tvLikes.setText(likes.toString())

        }
        binding.fabDislike.setOnClickListener {
            likes--
            binding.tvLikes.setText(likes.toString())
        }

        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (view?.parent as View).setBackgroundColor(Color.TRANSPARENT)
        val resources = resources

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            assert(view != null)
            val parent = view?.parent as View
            val layoutParams = parent.layoutParams as CoordinatorLayout.LayoutParams
            layoutParams.setMargins(
                64, // LEFT 16dp
                0,
                64, // RIGHT 16dp
                0
            )
            layoutParams.height = 1200
            parent.layoutParams = layoutParams
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        likes = 0
    }

    companion object {
        @JvmStatic
        fun newInstance(param: ParliamentMember) =
            MemberFragment().apply {
                mMember = param
            }
    }
}