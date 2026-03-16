package br.com.fiap.ecobairro.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.fiap.ecobairro.components.WaveShape

// 1. O Formato (pode ficar privado para este arquivo se não for usar em outro lugar)
private val WaveShape = GenericShape { size: Size, _ ->
    moveTo(0f, 0f)
    lineTo(size.width, 0f)
    lineTo(size.width, size.height * 0.7f)
    cubicTo(
        size.width * 0.6f, size.height * 1.1f,
        size.width * 0.3f, size.height * 0.5f,
        0f, size.height * 0.9f
    )
    close()
}

// 2. O Componente
@Composable
fun HeaderWave(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFF00C86F),
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(350.dp)
            .clip(WaveShape)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}