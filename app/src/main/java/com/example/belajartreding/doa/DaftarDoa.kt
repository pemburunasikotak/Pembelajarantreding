package com.example.belajartreding.doa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belajartreding.DetailDoa
import com.example.belajartreding.R
import kotlinx.android.synthetic.main.activity_daftar_doa.*

class DaftarDoa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_doa)
      //  rvData = findViewById(R.id.rv_doa)
       // rvData.setHasFixedSize(true)
        val modeldoa = ArrayList<ModelDoa>()
        modeldoa.add(
            ModelDoa("1","Bangun pagi","\"Oḿ Utedānīm bhagavantaḥ syāmota prapitva utamadhye ahnam," +
                " utoditā maghavanta sūryasya vayaḿ devānām sumatau syāma","Ya Tuhan, hamba memuja-Mu, " +
                "vahwa hamba telah bangun pagi dalam keadaan selamat",
                R.raw.bangun_pagi)
        )
        modeldoa.add(
            ModelDoa("2","Doa Menolak bahaya","\"Om Om Asta Maha Bayaya\n" +
                "Om Sarwa Dewa, Sarwa Sanjata, Sarwa Warna Ya Namah,\n" +
                "Om Atma Raksaya, Sarwa Satru, Winasaya Namah Swaha\n",
            "Oh Sanghyang Widhi Wasa Penakluk Segala Macam Bahaya Dari Segala Penjuru, Hamba Memujamu Dalam Wujud Sinar Suci " +
                    "Dengan Beraneka Warna Dan Senjata Yang Ampuh. Oh Sanghyang Widhi Wasa Lindungilah Jiwa Kami. Semoga Semua Musuh Binasa",
            R.raw.doa_terhindar_dari_segala_macam_bahaya)
        )
        modeldoa.add(
            ModelDoa("3",	"Doa Mandi",
            "Om Cam Camani Ya Namah Swaha"+
                    "Om Waktra Parisudaha Ya Namah Swaha",
            "Ya Tuhan, Hamba Memujamu, Semoga Muka Hamba Menjadi Bersih",
            R.raw.mandi
        )
        )
        modeldoa.add(
            ModelDoa("4",	"Doa menjelang tidur",
            "Om asato ma sat ganaya\n" +
                    "Tamaso ma jayatir ganaya\n" +
                    "Mrityor mamritam gamaya\n",
            "Ya tuhan tuntunlah hamba dari jalan yang sesat menuju jalan yang benar\n" +
                    "Dari jalan gelap ke jalan terang\n" +
                    "Hindarkanlah hamba dari kematian menuju kehidupan abadi\n",
            R.raw.menjelang_tidur
        )
        )
        modeldoa.add(
            ModelDoa("5",	"Doa Ampunan segala dosa",
            "Om dewakrtasyainaso awaya janam\n" +
                    "asi manusyakrtasi nama awaya janam\n" +
                    "asipitra kitasi namo awaya janam asyatma\n" +
                    "krtasyaenaso awaya janam\n" +
                    "asyena sa' enase waya janam asi\n" +
                    "yacchaham eno vidvamscakara\n" +
                    "yacchavidvams tasya va ya janam asi\n",
            "Om Sang Hyang Widhy Wasa, ampunilah dosa hamba terhadap-Mu. " +
                    "Ampunilah dosa hamba terhadap sesama manusia, " +
                    "terhadap orangtua hamba, terhadap teman hamba. " +
                    "Sang Hyang Widhy Wasa ampunilah dosa hamba terhadap segala macam dosa, " +
                    "terhadap dosa yang hamba lakukan dengan sadar atau tidak sadar. " +
                    "Sang Hyang Widhy Wasa semoga berkenan mengampuni semuanya itu.",
            R.raw.mohon_ampun_dlm_segala_dosa
        )
        )
        modeldoa.add(
            ModelDoa("6","Doa Mohon bimbingan tuhan",
        "Oṁ Asato mā sadyamaya\n" +
                "tamaso mā jyotir gamayamrtyor mā\n" +
                "amrtam gamaya,\n" +
                "Oṁ agne brahma grbhniswa\n" +
                "dharunama syanta riksam drdvamha\n" +
                "brahrnawanitwa ksatrawahi sajāta\n" +
                "wanyu dadhami bhratrwyasya wadhyāya.\n",
        "Oṁ Sang Hyang Widhy Wasa Yang Maha Suci, bimbinglah hamba \n" +
                "dari yang tidak benar menuju yang benar. Bimbinglah hamba \n" +
                "dari kegelapan pikiran menuju cahaya pengetahuan yang terang. \n" +
                "Lepaskanlah hamba dari kematian menuju kehidupan yang abadi. \n" +
                "Sang Hyang Widhy Wasa Yang Maha Suci,\n" +
                " terimalah pujian yang hamba persembahkan melalui Weda mantra\n" +
                " dan kembangkanlah pengetahuan rohani hamba agar hamba \n" +
                "dapat menghancurkan musuh yang ada pada hamba (nafsu). \n" +
                "Hamba menyadari bahwa Engkaulah yang berada dalam setiap insani (jiwatman), \n" +
                "menolong orang terpelajar pemimpin negara dan para pejabat. \n" +
                "Hamba memuja Engkau semoga melimpahkan anugrah kekuatan kepada hamba.\n",
        R.raw.mohon_bimbingan_tuhan)
        )
        modeldoa.add(
            ModelDoa("7",	"Mohon cinta kasih-Nya",
            "Oṁ wicakrame prthiwim esa etām\n" +
                    "ksetrāya wisnur manuse dasasyan\n" +
                    "druwāso asya kirqya janāsa\n" +
                    "uruksitim sujanimā cakāra\n",
            "Oṁ Sang Hyang Widhy Wasa, Engkau Hyang Wisnu yang membentang di bumi ini, " +
                    "menjadikah tempat tinggal bagi manusia. Kaum yang hina aman sentosa di bawah lindungan-Nya. " +
                    "Yang mulia telah menjadikan bumi tempat yang lega bagi mereka.",
            R.raw.mohon_cinta_kasih_nya
        )
        )
        modeldoa.add(
            ModelDoa("8",	"Doa Mohon inspirasi",
            "Oṁ prano Dewi Saraswati\n" +
                    "wājebhir wājiniwati\n" +
                    "dhinam awiñyawantu.\n",
            "Oṁ Sang Hyang Widhy Wasa dalam manifestasi Dewi Saraswati, " +
                    "Hyang Maha Agung dan Maha Kuasa, semoga Engkau memancarkan kekuatan rohani, " +
                    "kecerdasan pikiran, dan lindungilah hamba selama-lamanya.",
            R.raw.mohon_inspirasi
        )
        )
        modeldoa.add(
            ModelDoa("9",	"Doa untuk memohon ketenangan rumah tangga",
            "Oṁ prano Dewi Saraswati\n" +
                    "wājebhir wājiniwati\n" +
                    "dhinam awiñyawantu.\n",
            "Oṁ Sang Hyang Widhy Wasa dalam manifestasi Dewi Saraswati, " +
                    "Hyang Maha Agung dan Maha Kuasa, semoga Engkau memancarkan kekuatan rohani, " +
                    "kecerdasan pikiran, dan lindungilah hamba selama-lamanya.",
            R.raw.mohon_inspirasi
        )
        )
        modeldoa.add(
            ModelDoa("10",	"Mohon umur panjang",
            "Oṁ Taccaksur dewahitam sukram uccarat\n" +
                    "pasyema saradah satam\n" +
                    "jiwema saradah satam\n",
            "Oṁ Sang Hyang Widhy Wasa Yang Maha Kuasa, " +
                    "semoga seratus tahun hamba selalu melihat mata yang bersinar ciptaanNya, " +
                    "semoga hamba hidup seratus tahun lamanya",
            R.raw.mohon_umur_panjang
        )
        )

        rv_doa.layoutManager =LinearLayoutManager(this)
        rv_doa.adapter = AdapterDoa(modeldoa, {modeldoa -> personItemClicked(modeldoa as ModelDoa)  })
   }
        private fun personItemClicked(person: ModelDoa) {

        val bundel = Bundle()
        bundel.putString("name", person.name)
        bundel.putString("doatext", person.doatext)
        bundel.putString("doaarti", person.doatextarti)
        bundel.putInt("lagu",person.doasuara)
        val intent = Intent(this, DetailDoa::class.java)
        intent.putExtras(bundel)
        startActivity(intent)
    }
//
//    private fun fungsiRecyleView() {
//        val listadapter = AdapterDoa(this,list)
//        rvData.adapter = listadapter
//        rvData.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//
//        //deklarasi untuk Database
//        var myRef = FirebaseDatabase.getInstance().getReference("Doa")
//        //isi data di RV
//        myRef.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                for (snap in snapshot.children) {
//                    val x = snap.getValue(ModelDoa::class.java)
//                    //Log.e("testsoal", Gson().toJson(x))
//                    list.add(x!!)
//                    listadapter.notifyDataSetChanged()
//                }
//            }
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//        })
 //   }
}