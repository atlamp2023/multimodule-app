package com.github.atlamp2023.features.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.fragment.app.Fragment
import com.github.atlamp2023.features.main.domain.TestUseCase
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf

class MainFragment: Fragment() {

    private var useCase: TestUseCase = get()

    private val viewModel: MainViewModel by lazy {
        getViewModel (parameters = { parametersOf( useCase ) } )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                showSimpleUi()
            }
        }
    }

    @Composable
    private fun showSimpleUi(){
        val state = viewModel.state.collectAsState().value

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = state.command ?: "",
                fontSize = 16.sp,
                fontWeight = Bold,
                modifier = Modifier
                    .padding(bottom = 20.dp)
            )
            Text(
                text = state.description ?: "",
                modifier = Modifier
                    .padding(bottom = 20.dp)
            )
            TextButton(
                onClick = { viewModel.getData() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)
            ) {
                Text(text = "Reload")
            }
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}