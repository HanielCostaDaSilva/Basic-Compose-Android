package com.haniel.blog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haniel.blog.ui.theme.BlogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BlogDisplay(
                        modifier = Modifier.padding(16.dp),
                        title = stringResource(R.string.title_page_text),
                        content = stringResource(R.string.blog_content_text)
                    )
                }
            }
        }
    }


    // ATIVIDADE 1 - Artigo sobre o Compose
    @Composable
    fun BlogDisplay(modifier: Modifier, title: String, content: String) {
        val image = painterResource(R.drawable.bg_compose_background)
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = image,
                contentDescription = null,
                alpha = 0.5F,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = title,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = content,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }

    @Composable
    fun BlogDisplayPreview() {
        BlogTheme {
            BlogDisplay(modifier=Modifier,
                title= stringResource(R.string.title_page_text),
                content = stringResource(R.string.blog_content_text
            )
            )
        }
    }

// ATIVIDADE 2 - Task Manager
    @Preview(showBackground = true)
    @Composable
    fun AllTasksCompleteDisplay(modifier: Modifier) {
        val image = painterResource(R.drawable.ic_task_completed)
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(painter = image, contentDescription = null)
            Text(
                text = stringResource(R.string.task_complete_message),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Text(
                text = stringResource(R.string.nice_work),
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

    }

        @Preview(showBackground = true)
        @Composable
        fun AllTasksCompletePreview() {
            BlogTheme {
                AllTasksCompleteDisplay(modifier = Modifier)
            }
        }

    @Composable
    fun FourQuadrantsScreen(modifier: Modifier) {
        val composableFunctions = listOf(
            "Text composable" to "Displays text and follows the recommended Material Design guidelines.",
            "Image composable" to "Creates a composable that lays out and draws a given Painter class object.",
            "Row composable" to "A layout composable that places its children in a horizontal sequence.",
            "Column composable" to "A layout composable that places its children in a vertical sequence."
        )
        Column(modifier = modifier.fillMaxSize()) {
            Row(modifier = modifier.weight(1f)) {
                QuadrantsBox(title = composableFunctions[0].first, description = composableFunctions[0].second,backgroundColor= Color(0xFFEADDFF), modifier = modifier.weight(1f))
                QuadrantsBox(title = composableFunctions[1].first, description = composableFunctions[1].second, backgroundColor=Color(0xFFD0BCFF) ,modifier = modifier.weight(1f))
            }
            Row(modifier = modifier.weight(1f)) {
                QuadrantsBox(title = composableFunctions[2].first, description = composableFunctions[2].second,backgroundColor=Color(0xFFB69DF8), modifier = modifier.weight(1f))
                QuadrantsBox(title = composableFunctions[3].first, description = composableFunctions[3].second,backgroundColor=Color(0xFFF6EDFF), modifier = modifier.weight(1f))
            }
        }

    }

    @Composable
    fun QuadrantsBox(title: String, description: String, modifier: Modifier, backgroundColor: Color) {
        Card(
            modifier = modifier
                .padding(16.dp)
                .background(backgroundColor)
                .fillMaxSize(),

            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = description,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun FourQuadrantsScreenDisplay() {
        BlogTheme {
            FourQuadrantsScreen(modifier = Modifier)
        }

    }
}