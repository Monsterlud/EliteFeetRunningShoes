package com.udacity.elitefeetrunningshoes.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.udacity.elitefeetrunningshoes.R
import com.udacity.elitefeetrunningshoes.databinding.FragmentShoeDetailBinding
import com.udacity.elitefeetrunningshoes.models.Shoe
import com.udacity.elitefeetrunningshoes.shoelist.ShoeViewModel
import java.util.Locale

class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_shoe_detail,
                container,
                false,
            )

        binding.btnAddToInventory.setOnClickListener {
            val name = binding.etShoeNameInput.text.toString().capitalizeFirstletter()
            val company = binding.etShoeCompanyInput.text.toString().capitalizeFirstletter()
            val description = binding.etShoeDescriptionInput.text.toString()
            val url = binding.etImageInput.text.toString()

            if (name.isEmpty() || company.isEmpty() || description.isEmpty() || url.isEmpty()) {
                Toast.makeText(activity, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val size = binding.etShoeSizeInput.text.toString().toDouble()
                val shoe =
                    Shoe(
                        name,
                        size,
                        company,
                        description,
                        listOf(url),
                    )
                viewModel.addShoe(shoe)
                clearFields()
                requireActivity().onBackPressed()
            } catch (e: NumberFormatException) {
                Toast.makeText(activity, "Shoe size must be a number", Toast.LENGTH_SHORT).show()
            }
        }
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    private fun clearFields() {
        binding.etShoeNameInput.text = null
        binding.etShoeCompanyInput.text = null
        binding.etShoeDescriptionInput.text = null
        binding.etShoeSizeInput.text = null
        binding.etImageInput.text = null
    }

    fun String.capitalizeFirstletter() : String {
        return this.replaceFirstChar {
            if (it.isLowerCase()) {
                it.titlecase(Locale.getDefault())
            } else it.toString()
        }
    }
}
