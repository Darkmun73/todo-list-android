package io.github.darkmun.todolist.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("CheckReturnValue")
public val play_arrow: ImageVector
    get() {
        if (_play_arrow != null) {
            return _play_arrow!!
        }
        _play_arrow =
            ImageVector.Builder(
                name = "play_arrow",
                defaultWidth = 8.5.dp, // Matches new aspect ratio (optional, scales to Modifier.size)
                defaultHeight = 11.dp,
                viewportWidth = 8.5f,  // 15.5f - 7f
                viewportHeight = 11f,  // 15.5f - 4.5f
            )
                .apply {
                    group(
                        translationX = -7f,   // Shifts left edge from 7f to 0f
                        translationY = -4.5f  // Shifts top edge from 4.5f to 0f
                    ) {
                        path(
                            fill = SolidColor(Color.Black),
                            fillAlpha = 1f,
                            stroke = null,
                            strokeAlpha = 1f,
                            strokeLineWidth = 1f,
                            strokeLineCap = StrokeCap.Butt,
                            strokeLineJoin = StrokeJoin.Bevel,
                            strokeLineMiter = 1f,
                            pathFillType = PathFillType.Companion.NonZero,
                        ) {
                            moveTo(7f, 15.5f)
                            verticalLineTo(4.5f)
                            lineTo(15.5f, 10f)
                            lineTo(7f, 15.5f)
                            close()
                        }
                    }
                }
                .build()
        return _play_arrow!!
    }

private var _play_arrow: ImageVector? = null