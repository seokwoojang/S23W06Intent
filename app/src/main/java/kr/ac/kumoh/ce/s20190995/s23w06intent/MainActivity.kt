package kr.ac.kumoh.ce.s20190995.s23w06intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import kr.ac.kumoh.ce.s20190995.s23w06intent.ui.theme.S23W06IntentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            S23W06IntentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        modifier = modifier
    ){
        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                val uri = Uri.parse("https://www.youtube.com")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(context,intent,null)
            }
        ){
            Text("유튜브")
        }
        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                val uri = Uri.parse("https://www.instagram.com/newjeans_official/")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(context,intent,null)
            }
        ){
            Text("인스타그램")
        }
        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                val uri = Uri.parse("https://www.facebook.com/official.newjeans")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(context,intent,null)
            }
        ){
            Text("페이스북")
        }
        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                val uri = Uri.parse("geo:36.145014,128.393047?z=17")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(context,intent,null)
            }
        ){
            Text("좌표")
        }
        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                val uri = Uri.parse("geo:0,0?q=대구광역시 북구 구암로49길 10")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(context,intent,null)
            }
        ){
            Text("우리집")
        }
        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                val uri = Uri.parse("tel:01049147247")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(context,intent,null)
            }
        ){
            Text("전화")
        }
        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                val uri = Uri.parse("sms:01049147247")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                intent.putExtra("sms_body","전화 부탁드립니다.")
                startActivity(context,intent,null)
            }
        ){
            Text("sms")
        }
        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(context, SecondActivity::class.java)
                startActivity(context,intent,null)
            }
        ){
            Text("Activity")
        }
    }

}

//intent는 2가지 종류가 있음
//암시적인 intent : 해줘마인드
//AndroidManifest에 다 작성을 해놓고 실행해야함, 없이 실행하면 프로그램이 죽음, 보안문제 때문에 하는 것임.

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    S23W06IntentTheme {
        Greeting("Android")
    }
}