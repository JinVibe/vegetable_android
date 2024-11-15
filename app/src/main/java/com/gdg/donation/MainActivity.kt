package com.gdg.donation

// MainActivity.kt
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add LoginFragment to the activity
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, LoginFragment())
            .commit()

        // 메인 액티비티(로그인, 회원가입) -> 컨텐드 액티비티 (홈, 기부처, 농산품, 마이페이지) TODO 임시 설정, 추후 리팩토링
        startActivity(Intent(this, ContentActivity::class.java))
        finish() // 메인 액티비티 종료
    }
}
