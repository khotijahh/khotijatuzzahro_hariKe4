package com.example.khotijatuzzahro_harike4

import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var Bil1 : EditText
    private lateinit var Bil2 : EditText
    private lateinit var tambah : Button
    private lateinit var kurang : Button
    private lateinit var bagi : Button
    private lateinit var kali : Button
    private lateinit var hasil : TextView
    private lateinit var hapus : Button
    private lateinit var tambahData : Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Bil1 = findViewById(R.id.editBil1)
        Bil2 = findViewById(R.id.editBil2)
        hasil = findViewById(R.id.tvHasil2)
        kurang = findViewById(R.id.btnMin)
        kali = findViewById(R.id.btnKali)
        bagi = findViewById(R.id.btnBagi)
        tambah = findViewById(R.id.btnTambah)
        hapus = findViewById(R.id.btnDelete)
        tambahData = findViewById(R.id.btnSimpan)
        recyclerView = findViewById(R.id.listData)

        // membuat variabel kosong tipe array mutableList untuk simpan data array
        // data array di simpan di data class siswaData

        val data = mutableListOf<DataKalku>()
        viewManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerAdapter = EditActivity(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager

        tambah.setOnClickListener { tambah() }
        kurang.setOnClickListener { kurang() }
        kali.setOnClickListener { kali() }
        bagi.setOnClickListener { bagi() }
        hapus.setOnClickListener { hapus() }

        tambahData.setOnClickListener {
            val satu = Bil1.text.toString()
            val dua = Bil2.text.toString()
            val hasil = hasil.text.toString()

            val dataSiswa = DataKalku(satu, dua, hasil)
            data.add(dataSiswa)
            recyclerAdapter.notifyDataSetChanged()
        }
    }
    fun tambah(){
        val hitung = Bil1.text.toString().toDouble() + Bil2.text.toString().toDouble()
        hasil.text = hitung.toString()
    }
    fun  kurang(){
        val hitung = Bil1.text.toString().toDouble() - Bil2.text.toString().toDouble()
        hasil.text = hitung.toString()
    }
    fun kali(){
        val hitung = Bil1.text.toString().toDouble() * Bil2.text.toString().toDouble()
        hasil.text = hitung.toString()
    }
    fun bagi(){
        val hitung = Bil1.text.toString().toDouble() / Bil2.text.toString().toDouble()
        hasil.text = hitung.toString()
    }
    fun hapus(){
        hasil.text = "0"
        Bil1.text.clear()
        Bil2.text.clear()
    }
}