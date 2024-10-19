
package com.example.imageinteractionfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.imageinteractionfragments.databinding.FragmentViewerBinding

class ViewerFragment : Fragment() {

    private lateinit var binding: FragmentViewerBinding
    private var imageName: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewerBinding.inflate(inflater, container, false)
        imageName = arguments?.getString("imageName")

        when (imageName) {
            "Imagen 1" -> binding.imageView.setImageResource(R.drawable.imagen1)
            "Imagen 2" -> binding.imageView.setImageResource(R.drawable.imagen2)
            "Imagen 3" -> binding.imageView.setImageResource(R.drawable.imagen3)
        }

        binding.buttonBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }

    companion object {
        fun newInstance(imageName: String) = ViewerFragment().apply {
            arguments = Bundle().apply {
                putString("imageName", imageName)
            }
        }
    }
}
