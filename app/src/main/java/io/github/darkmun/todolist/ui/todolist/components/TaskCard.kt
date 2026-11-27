package io.github.darkmun.todolist.ui.todolist.components

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.darkmun.todolist.R
import io.github.darkmun.todolist.domain.model.TaskStatus
import io.github.darkmun.todolist.ui.icons.check
import io.github.darkmun.todolist.ui.icons.delete
import io.github.darkmun.todolist.ui.icons.play_arrow
import io.github.darkmun.todolist.ui.theme.DuoPalette
import io.github.darkmun.todolist.ui.theme.TODOListTheme
import io.github.darkmun.todolist.ui.todolist.TaskUiState


@Composable
fun TaskCard(onClick: () -> Unit, modifier: Modifier = Modifier, taskUiState: TaskUiState) {
    ElevatedCard(
        onClick = onClick,
        modifier = modifier
    ) {
        val horizontalPadding = 15.dp
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min)
        ) {
            VerticalDivider(
                thickness = 3.dp,
                color = taskUiState.status.getColorPalette().primary
            )
            Column {
                Column(
                    modifier = Modifier
                        .padding(horizontalPadding),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        StatusLabel(taskStatus = taskUiState.status)
                        Text(
                            text = taskUiState.dateTime,
                            style = MaterialTheme.typography.labelSmall,
                            color = TODOListTheme.extendedColors.onSurfaceVariant2
                        )
                    }
                    Text(
                        text = taskUiState.shortDescription,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
                HorizontalDivider(
                    color = TODOListTheme.extendedColors.divider,
                    thickness = 1.dp
                )
                TaskCardFooter(
                    taskStatus = taskUiState.status,
                    modifier = Modifier
                        .padding(horizontal = horizontalPadding)
                        .padding(top = 5.dp)
                )
            }
        }
    }
}

@Composable
fun TaskCardFooter(taskStatus: TaskStatus, modifier: Modifier = Modifier) {
    when (taskStatus) {
        TaskStatus.NEW -> NewStatusTaskCardFooter({}, {}, modifier = modifier)
        TaskStatus.IN_PROGRESS -> InProgressStatusTaskCardFooter({}, modifier = modifier)
        TaskStatus.DONE -> DoneStatusTaskCardFooter(modifier = modifier)
    }
}

@Composable
fun NewStatusTaskCardFooter(
    onChangeStatus: () -> Unit,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    val inProgressPalette = TaskStatus.IN_PROGRESS.getColorPalette()

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        TaskCardButton(
            onClick = onChangeStatus,
            containerColor = inProgressPalette.secondary,
            contentColor = inProgressPalette.primary
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = play_arrow,
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.mark_in_progress_button),
                    fontWeight = FontWeight.ExtraBold,
                    style = MaterialTheme.typography.labelMedium
                )

            }
        }
        TaskCardButton(
            onClick = onDelete,
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.error
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = delete,
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.delete_button),
                    fontWeight = FontWeight.ExtraBold,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}

@Composable
fun InProgressStatusTaskCardFooter(
    onChangeStatus: () -> Unit,
    modifier: Modifier = Modifier
) {
    val donePalette = TODOListTheme.statusColors.doneStatus
    TaskCardButton(
        onClick = onChangeStatus,
        modifier = modifier,
        containerColor = donePalette.secondary,
        contentColor = donePalette.primary
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = check,
                contentDescription = null
            )
            Text(
                text = stringResource(R.string.mark_done_button),
                fontWeight = FontWeight.ExtraBold,
                style = MaterialTheme.typography.labelMedium
            )

        }
    }
}
@Composable
fun DoneStatusTaskCardFooter(
    modifier: Modifier = Modifier
) {
    val donePalette = TODOListTheme.statusColors.doneStatus
    val buttonsDefaultPadding = ButtonDefaults.ContentPadding

    Row(
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(
                top = buttonsDefaultPadding.calculateTopPadding(),
                bottom = buttonsDefaultPadding.calculateBottomPadding()
            )
    ) {
        Icon(
            imageVector = check,
            contentDescription = null,
            tint = donePalette.primary
        )
        Text(
            text = stringResource(R.string.done_label),
            color = donePalette.primary,
            fontWeight = FontWeight.ExtraBold,
            style = MaterialTheme.typography.labelMedium
        )

    }
}

@Composable
fun TaskCardButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color,
    contentColor: Color,
    border: BorderStroke? = null,
    content: @Composable (RowScope.() -> Unit)
) {
    val defaultButtonColors = ButtonDefaults.buttonColors()

    Button(
        onClick = onClick,
        colors = ButtonColors(
            contentColor = contentColor,
            containerColor = containerColor,
            disabledContentColor = defaultButtonColors.disabledContentColor,
            disabledContainerColor = defaultButtonColors.disabledContainerColor
        ),
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 15.dp),
        shape = MaterialTheme.shapes.large,
        border = border,
        content = content
    )
}

@Composable
fun StatusLabel(taskStatus: TaskStatus, modifier: Modifier = Modifier) {
    Surface(
        shape = MaterialTheme.shapes.small,
        color = taskStatus.getColorPalette().secondary,
        contentColor = taskStatus.getColorPalette().primary
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(7.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .align(Alignment.CenterVertically)
                    .background(
                        color = LocalContentColor.current,
                        shape = CircleShape
                    )
            )
            Text(
                text = stringResource(taskStatus.getLabelResourceId()),
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@StringRes
private fun TaskStatus.getLabelResourceId() = when (this) {
    TaskStatus.NEW -> R.string.new_status
    TaskStatus.IN_PROGRESS -> R.string.in_progress_status
    TaskStatus.DONE -> R.string.done_status
}

@Composable
private fun TaskStatus.getColorPalette(): DuoPalette {
    val colors = TODOListTheme.statusColors
    return when (this) {
        TaskStatus.NEW -> colors.newStatus
        TaskStatus.IN_PROGRESS -> colors.inProgressStatus
        TaskStatus.DONE -> colors.doneStatus
    }
}

@Preview
@Composable
fun TaskCardPreview() {
    TODOListTheme {
        TaskCard(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth(),
            TaskUiState(
                status = TaskStatus.DONE,
                shortDescription = "Пример краткого описания",
                dateTime = "26.11.2026, 15:33"
            )
        )
    }
}
