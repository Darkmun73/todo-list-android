package io.github.darkmun.todolist.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class DuoPalette(
    val primary: Color,
    val secondary: Color
)

@Immutable
data class StatusColors(
    val newStatus: DuoPalette,
    val inProgressStatus: DuoPalette,
    val doneStatus: DuoPalette
)

@Immutable
data class ExtendedColors(
    val onSurfaceVariant2: Color,
    val divider: Color
)

val LightStatusColors = StatusColors(
    newStatus = DuoPalette(primary = Gray53, secondary = Gray95),
    inProgressStatus = DuoPalette(primary = CharmingBlue37, secondary = VioletGray95),
    doneStatus = DuoPalette(primary = Green49, secondary = SwampGreen96)
)

private val LightColorScheme = lightColorScheme(
    secondaryContainer = BlackBlue,
    onSecondaryContainer = White100,
    surfaceContainerLow = White100,
    onSurfaceVariant = GrayBlue80,
    background = White98

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

val LightExtendedColors = ExtendedColors(
    onSurfaceVariant2 = Gray64,
    divider = Gray95
)

val LocalStatusColors = staticCompositionLocalOf { LightStatusColors }
val LocalExtendedColors = staticCompositionLocalOf { LightExtendedColors }

@Composable
fun TODOListTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalStatusColors provides LightStatusColors,
        LocalExtendedColors provides LightExtendedColors
    ) {
        MaterialTheme(
            colorScheme = LightColorScheme,
            typography = Typography,
            content = content
        )
    }
}

object TODOListTheme {
    val statusColors: StatusColors
        @Composable
        get() = LocalStatusColors.current

    val extendedColors: ExtendedColors
        @Composable
        get() = LocalExtendedColors.current
}