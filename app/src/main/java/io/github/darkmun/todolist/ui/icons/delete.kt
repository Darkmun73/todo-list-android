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
public val delete: ImageVector
    get() {
        if (_delete != null) {
            return _delete!!
        }
        _delete =
            ImageVector.Builder(
                name = "delete",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f,
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
                        moveTo(6.76f, 16.58f)
                        quadToRelative(-0.55f, 0f, -0.95f, -0.39f)
                        reflectiveQuadTo(5.42f, 15.24f)
                        verticalLineTo(5.5f)
                        horizontalLineToRelative(-1f)
                        verticalLineTo(4.42f)
                        horizontalLineTo(8f)
                        verticalLineTo(3.51f)
                        horizontalLineToRelative(4f)
                        verticalLineToRelative(0.9f)
                        horizontalLineToRelative(3.58f)
                        verticalLineTo(5.5f)
                        horizontalLineToRelative(-1f)
                        verticalLineToRelative(9.73f)
                        quadToRelative(0f, 0.58f, -0.39f, 0.96f)
                        reflectiveQuadToRelative(-0.95f, 0.39f)
                        horizontalLineTo(6.76f)
                        close()
                        moveTo(13.5f, 5.5f)
                        horizontalLineToRelative(-7f)
                        verticalLineToRelative(9.74f)
                        quadToRelative(0f, 0.11f, 0.07f, 0.18f)
                        reflectiveQuadTo(6.76f, 15.5f)
                        horizontalLineToRelative(6.49f)
                        quadToRelative(0.1f, 0f, 0.18f, -0.08f)
                        reflectiveQuadTo(13.5f, 15.24f)
                        verticalLineTo(5.5f)
                        close()
                        moveTo(8.34f, 14f)
                        horizontalLineTo(9.42f)
                        verticalLineTo(7f)
                        horizontalLineTo(8.34f)
                        verticalLineToRelative(7f)
                        close()
                        moveToRelative(2.24f, 0f)
                        horizontalLineToRelative(1.08f)
                        verticalLineTo(7f)
                        horizontalLineTo(10.58f)
                        verticalLineToRelative(7f)
                        close()
                        moveTo(6.5f, 5.5f)
                        verticalLineToRelative(9.74f)
                        quadToRelative(0f, 0.11f, 0f, 0.18f)
                        reflectiveQuadToRelative(0f, 0.07f)
                        quadToRelative(0f, 0f, 0f, -0.07f)
                        reflectiveQuadToRelative(0f, -0.18f)
                        verticalLineTo(5.5f)
                        close()
                    }
                }
                .build()
        return _delete!!
    }

private var _delete: ImageVector? = null