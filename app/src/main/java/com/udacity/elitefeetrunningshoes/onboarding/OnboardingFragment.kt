package com.udacity.elitefeetrunningshoes.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.elitefeetrunningshoes.R
import com.udacity.elitefeetrunningshoes.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment() {
    private lateinit var binding: FragmentOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_onboarding,
                container,
                false,
            )
        val image = binding.fullScreenImage
        image.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.onboarding_image, null))

        binding.btnInstructions.setOnClickListener {
            findNavController().navigate(OnboardingFragmentDirections.actionOnboardingFragmentToInstructionsFragment())
        }
        return binding.root
    }
}
