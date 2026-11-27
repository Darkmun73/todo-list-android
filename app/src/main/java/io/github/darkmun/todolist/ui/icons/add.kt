package io.github.darkmun.todolist.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("CheckReturnValue")
public val add: ImageVector
    get() {
        if (_add != null) {
            return _add!!
        }
        _add =
            ImageVector.Builder(
                name = "add",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f,
            )
                .apply {
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
                        moveTo(10.86f, 13.14f)
                        horizontalLineTo(4.8f)
                        verticalLineTo(10.86f)
                        horizontalLineToRelative(6.07f)
                        verticalLineTo(4.8f)
                        horizontalLineToRelative(2.28f)
                        verticalLineToRelative(6.07f)
                        horizontalLineTo(19.2f)
                        verticalLineToRelative(2.28f)
                        horizontalLineTo(13.14f)
                        verticalLineTo(19.2f)
                        horizontalLineTo(10.86f)
                        verticalLineTo(13.14f)
                        close()
                    }
                }
                .build()
        return _add!!
    }

private var _add: ImageVector? = null