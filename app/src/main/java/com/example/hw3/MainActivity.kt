package com.example.hw3

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = "Zinciri Kırma"

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = recycler_adapter(arrayOf(
            "Kotlin",
            "Giriş - Tasarım",
            "Çalışma Yapısı",
            "Widgets-Kulanıcı Etkileşim",
            "Material Design",
            "Uygulama Mimarisi",
            "Depolama İşlemleri",
            "Depolama - İleri Android",
            "İnternet Tabanlı İşlemler",
            "İnternet - Lokasyon İşlemleri"
        ),this)

    }
}