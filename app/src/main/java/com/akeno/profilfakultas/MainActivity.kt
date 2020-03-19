package com.akeno.profilfakultas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = createFakultasData()
        fakultasParts.layoutManager = LinearLayoutManager(this)
        fakultasParts.setHasFixedSize(true)
        fakultasParts.adapter = FakultasAdapter(testData, { fakultasItem: FakultasData -> fakultasItemClicked(fakultasItem)})
    }

    private fun fakultasItemClicked(fakultasItem: FakultasData) {
        val showDetailActivityIntent = Intent(this, FakultasDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, fakultasItem.namaFakultas.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEMPLATE, fakultasItem.deskripsiFakultas.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_COMPONENT_NAME, fakultasItem.listProdi.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_REFERRER, fakultasItem.fotoFakultas.toString())
        startActivity(showDetailActivityIntent)
    }

    private fun createFakultasData() : List<FakultasData> {
        val partList = ArrayList<FakultasData>()
        partList.add(FakultasData("Fakultas Ilmu Komputer", "1. Sistem Informasi\n2. Teknik Informatika", "Fakultas Ilmu Komputer merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang terdiri dari program studi", R.drawable.upn))
        partList.add(FakultasData("Fakultas Teknik", "1. Teknik Kimia\n2. Teknik Industri\n3. Teknik Pangan\n4. Teknik Lingkungan\n5. Teknik Sipil", "Fakultas Teknik merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang terdiri dari program studi", R.drawable.upn))
        partList.add(FakultasData("Fakultas Ekonomi dan Bisnis", "1. Ekonomi Pembangunan\n2. Manajemen\n3. Akuntansi", "Fakultas Ekonomi dan Bisnis merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang terdiri dari program studi", R.drawable.upn))
        partList.add(FakultasData("Fakultas  Pertanian", "1. Agroteknologi\n2. Agribisnis", "Fakultas Pertanian merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang terdiri dari program studi", R.drawable.upn))
        partList.add(FakultasData("Achmad Fauzi", "1. Tempat, Tanggal Lahir: Surabaya, 10 Juli 1999\n2. Alamat: Jl. Jojoran 3A\n3. No.HP: 082257888500\n4. Email: fauziofficial10@gmail.com\n5. Url Github: https://github.com/fauzivwxyz\n6. Riwayat Pendidikan: \n\t SD: SDN Mojo V\n\t SMP: SMPN 6 Surabaya \n\t SMA: SMAN 7 Surabaya\n7. Penghargaan: - ", "", R.drawable.fauzi))
        return partList

    }
}
