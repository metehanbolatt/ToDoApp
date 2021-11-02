package com.metehanbolat.todoappcompose.data.models

import androidx.compose.ui.graphics.Color
import com.metehanbolat.todoappcompose.ui.theme.HighPriorityColor
import com.metehanbolat.todoappcompose.ui.theme.LowPriorityColor
import com.metehanbolat.todoappcompose.ui.theme.MediumPriorityColor
import com.metehanbolat.todoappcompose.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}