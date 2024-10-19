
package com.example.imageinteractionfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.imageinteractionfragments.databinding.FragmentSelectorBinding

class SelectorFragment : Fragment() {

    private lateinit var binding: FragmentSelectorBinding
    private var selectedImage: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectorBinding.inflate(inflater, container, false)

        val imageNames = arrayOf("Imagen 1", "Imagen 2", "Imagen 3")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, imageNames)
        binding.spinner.adapter = adapter

        selectedImage = savedInstanceState?.getString("selectedImage")
        selectedImage?.let {
            binding.spinner.setSelection(imageNames.indexOf(it))
        }

        binding.buttonNext.setOnClickListener {
            selectedImage = binding.spinner.selectedItem.toString()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ViewerFragment.newInstance(selectedImage!!))
                .addToBackStack(null)
                .commit()
        }

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("selectedImage", binding.spinner.selectedItem.toString())
    }
}
