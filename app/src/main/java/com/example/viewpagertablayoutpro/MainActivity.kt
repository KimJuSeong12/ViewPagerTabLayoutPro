package com.example.viewpagertablayoutpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.get
import com.example.viewpagertablayoutpro.databinding.ActivityMainBinding
import com.example.viewpagertablayoutpro.databinding.UsertabButtonBinding
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var customAdapter: CustomAdapter
    lateinit var tabTitleList: MutableList<String>
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        customAdapter = CustomAdapter(this)
        customAdapter.addListFragment(OneFragment())
        customAdapter.addListFragment(TwoFragment())
        customAdapter.addListFragment(ThreeFragment())
        tabTitleList = mutableListOf("car", "home", "air")
        binding.viewPager2.adapter = customAdapter
        binding.navigationView.setNavigationItemSelectedListener(this)
/*        val tab1: TabLayout.Tab = binding.tabLayout.newTab()
        val tab2: TabLayout.Tab = binding.tabLayout.newTab()
        val tab3: TabLayout.Tab = binding.tabLayout.newTab()
        tab1.text = "FRAG1"
        tab2.text = "FRAG2"
        tab3.text = "FRAG3"
        binding.tabLayout.addTab(tab1)
        binding.tabLayout.addTab(tab2)
        binding.tabLayout.addTab(tab3)*/
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.setCustomView(tabCustomView(position))
        }.attach()
        // 1. 액션바 대신에 툴바로 대체
        setSupportActionBar(binding.toolbar)
        // 2. ActionBarDrawerToggle 버튼 적용
        toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            R.string.drawer_open,
            R.string.drawer_close
        )
        // 3. 업버튼 활성화
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // 4. 토글 sync
        toggle.syncState()

    }

    fun tabCustomView(position: Int): View {
        val binding = UsertabButtonBinding.inflate(layoutInflater)
        when (position) {
            0 -> binding.ivIcon.setImageResource(R.drawable.car)
            1 -> binding.ivIcon.setImageResource(R.drawable.house)
            2 -> binding.ivIcon.setImageResource(R.drawable.airplane)
        }
        binding.tvTabName.text = tabTitleList.get(position)
        return binding.root
    }

    // 메뉴 토글버튼을 눌렀을 때 네비게이션바를 보여주는 역할
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_info -> Toast.makeText(this, "앱정보 클릭", Toast.LENGTH_SHORT).show()
            R.id.item_user -> Toast.makeText(this, "사용자정보 클릭", Toast.LENGTH_SHORT).show()
            R.id.item_age -> Toast.makeText(this, "사용자나이 클릭", Toast.LENGTH_SHORT).show()
            R.id.item_email -> Toast.makeText(this, "사용자이메일 클릭", Toast.LENGTH_SHORT).show()
        }
        return false
    }
}