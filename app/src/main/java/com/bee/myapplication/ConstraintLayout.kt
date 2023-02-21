package com.bee.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

class ConstraintLayout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val constraintSet = ConstraintSet {
                val yellowBoxRef = createRefFor("yellowBox")
                val blueBoxRef = createRefFor("blueBox")

                constrain(yellowBoxRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(blueBoxRef.start)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }

                constrain(blueBoxRef) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    start.linkTo(yellowBoxRef.end)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }

                createHorizontalChain(yellowBoxRef,blueBoxRef, chainStyle = ChainStyle.Packed)

            }


            ConstraintLayout(constraintSet, modifier = Modifier.fillMaxSize()) {
                Box(modifier = Modifier
                    .background(Color.Yellow)
                    .layoutId("yellowBox"))
                Box(modifier = Modifier
                    .background(Color.Blue)
                    .layoutId("blueBox"))
            }
        }
    }
}
