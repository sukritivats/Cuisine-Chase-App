//package com.example.cuisinechase.Views
//
//import android.net.Uri
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.navigation.fragment.findNavController
//import com.example.cuisinechase.R
//import com.example.cuisinechase.databinding.FragmentARBinding
//import com.google.ar.core.Anchor
//import com.google.ar.sceneform.AnchorNode
//import com.google.ar.sceneform.rendering.ModelRenderable
//import com.google.ar.sceneform.ux.ArFragment
//import com.google.ar.sceneform.ux.TransformableNode
//import io.github.sceneview.nodes.ModelNode
//
//
//class ARFragment : Fragment() {
//
//    private val binding by lazy { FragmentARBinding.inflate(layoutInflater) }
//    private lateinit var arFragment: ArFragment
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?,
//    ): View? {
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        init()
//    }
//
//    private fun init() {
//
//        arFragment.setOnTapArPlaneListener { hitResult, _, _ ->
//            val anchor = hitResult.createAnchor()
//            placeModel(anchor)
//        }
//    }
//    private fun placeModel(anchor: Anchor) {
//        ModelRenderable.builder()
//            .setSource(this, Uri.parse("model.glb"))
//            .build()
//            .thenAccept { renderable ->
//                val anchorNode = AnchorNode(anchor)
//                anchorNode.setParent(arFragment.arSceneView.scene)
//                val modelNode = TransformableNode(arFragment.transformationSystem)
//                modelNode.renderable = renderable
//                modelNode.setParent(anchorNode)
//                arFragment.arSceneView.scene.addChild(anchorNode)
//            }
//    }
//
//}