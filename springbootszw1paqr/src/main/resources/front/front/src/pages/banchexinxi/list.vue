<template>
<div>
	<div :style='{"border":"1px solid #D8D8D8","padding":"16px 20px 10px","margin":"65px auto 20px","borderRadius":"0","background":"transparent","borderWidth":"0 0 3px","width":"68%"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'》'" :style='{"fontSize":"14px","lineHeight":"1"}'>
			<el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
			<el-breadcrumb-item class="item2" v-for="(item, index) in breadcrumbItem" :key="index"><a>{{item.name}}</a></el-breadcrumb-item>
		</el-breadcrumb>
	</div>
	<div v-if="centerType" :style='{"border":"1px solid #D8D8D8","padding":"16px 20px 10px","margin":"65px auto 20px","borderRadius":"0","background":"transparent","borderWidth":"0 0 3px","width":"68%"}'>
		<el-button size="mini" @click="backClick">返回</el-button>
	</div>
	<div class="list-preview" :style='{"minHeight":"100vh","width":"68%","margin":"10px auto","position":"relative","background":"#F6F6F6"}'>
		

		<div class="category-3" :style='{"padding":"10px","borderRadius":"10px","left":"-210px","background":"#fff","flexDirection":"column","display":"flex","width":"210px","position":"absolute","height":"auto"}'>
			<div class="item" :class="swiperIndex == '-1' ? 'active' : ''" @click="getList(1, '全部')" :plain="isPlain">
				<div :style='{"width":"calc(100% - 44px)","margin":"0 0 0 10px","fontSize":"14px","color":"inherit","textAlign":"left"}'>全部</div>
			</div>
			<div class="item" :class="swiperIndex == index ? 'active' : ''" v-for="(item, index) in fenlei" :key="index" @click="getList(1, item[feileiColumn], 'btn' + index)" :ref="'btn' + index" plain>
				<img v-if="item.image" :style='{"width":"34px","margin":"0","objectFit":"cover","borderRadius":"50%","display":"block","height":"34px"}' :src="baseUrl + (item.image?item.image.split(',')[0]:'')">
				<div :style='{"width":"calc(100% - 44px)","margin":"0 0 0 10px","fontSize":"14px","color":"inherit","textAlign":"left"}'>{{item[feileiColumn]}}</div>
			</div>
		</div>
	
    <el-form :inline="true" :model="formSearch" class="list-form-pv" :style='{"padding":"10px","alignItems":"center","top":"130px","flexWrap":"wrap","left":"0","background":"transparent","display":"flex","width":"20%","position":"absolute","height":"auto"}'>
      <el-form-item :style='{"margin":"0 10px"}'>
	    <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","color":"#000","display":"inline-block"}'>班车车号：</div>
        <el-input v-model="formSearch.banchechehao" placeholder="班车车号" @keydown.enter.native="getList(1, curFenlei)" clearable></el-input>
      </el-form-item>
      <el-form-item :style='{"margin":"0 10px"}'>
	    <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","color":"#000","display":"inline-block"}'>始发站点：</div>
        <el-input v-model="formSearch.shifazhandian" placeholder="始发站点" @keydown.enter.native="getList(1, curFenlei)" clearable></el-input>
      </el-form-item>
      <el-form-item :style='{"margin":"0 10px"}'>
	    <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","color":"#000","display":"inline-block"}'>终点站点：</div>
        <el-input v-model="formSearch.zhongdianzhandian" placeholder="终点站点" @keydown.enter.native="getList(1, curFenlei)" clearable></el-input>
      </el-form-item>
      <el-form-item :style='{"margin":"0 10px"}'>
	    <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","color":"#000","display":"inline-block"}'>司机姓名：</div>
        <el-input v-model="formSearch.sijixingming" placeholder="司机姓名" @keydown.enter.native="getList(1, curFenlei)" clearable></el-input>
      </el-form-item>
      <el-form-item :style='{"margin":"0 10px"}'>
	    <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","color":"#000","display":"inline-block"}'>价格：</div>
        <el-input v-model="formSearch.pricestart" placeholder="最小价格" clearable></el-input>
      </el-form-item>
      <el-form-item :style='{"margin":"0 10px"}'>
        <el-input v-model="formSearch.priceend" placeholder="最大价格" clearable></el-input>
      </el-form-item>
	  <el-button v-if=" true " :style='{"cursor":"pointer","border":"0","padding":"0px 15px","margin":"20px 10px 0 0","outline":"none","color":"#fff","borderRadius":"60px","background":"#AD8936","width":"auto","fontSize":"15px","lineHeight":"42px","height":"42px"}' type="primary" @click="getList(1, curFenlei)"><i v-if="true" :style='{"color":"#fff","margin":"0 10px 0 0","fontSize":"16px"}' class="el-icon-search"></i>查询</el-button>
	  <el-button v-if="btnAuth('banchexinxi','新增')" :style='{"cursor":"pointer","border":"0","padding":"0px 15px","margin":"20px 10px 0 0","outline":"none","color":"#fff","borderRadius":"60px","background":"#313131","width":"auto","fontSize":"15px","lineHeight":"42px","height":"42px"}' type="primary" @click="add('/index/banchexinxiAdd')"><i v-if="true" :style='{"color":"#fff","margin":"0 10px 0 0","fontSize":"16px"}' class="el-icon-circle-plus-outline"></i>添加</el-button>
    </el-form>
	<div class="select2" :style='{"width":"100%","padding":"0","margin":"30px 0","background":"none","height":"auto"}'>
	  <div :style='{"padding":"0 12px 4px","margin":"4px 0","borderColor":"#fff","background":"#f5f5f5","borderWidth":"0 0 1px","width":"100%","position":"relative","borderStyle":"solid","height":"auto"}' class="list" v-for="(item,index) in selectOptionsList" :key="item">
	    <div :style='{"padding":"0 5px","lineHeight":"32px","fontSize":"14px","color":"#333","display":"inline-block"}' class="label">{{item.name}}：</div>
	    <div :style='{"width":"auto","flexWrap":"wrap","display":"inline-block","height":"auto"}' class="item-body">
	      <div class="item" @click="selectClick2(item,-1)" :class="item.check ==-1 ? 'active' : ''">全部</div>
	      <div class="item" @click="selectClick2(item,index1)" :class="item.check == index1 ? 'active' : ''" v-for="item1,index1 in item.list" :key="item1">{{item1}}</div>
	    </div>
	  </div>
	</div>
	<div class="sort_view" :style='{"width":"80%","padding":"10px 0","margin":"0 0 0 20%","alignItems":"center","background":"#fff","display":"flex"}'>
		<el-button :style='{"border":"0","padding":"0 15px","margin":"0 5px","borderRadius":"8px","display":"flex"}' @click="sortClick('price')">
			<span :style='{"margin":"0 2px 0 0","lineHeight":"40px","fontSize":"14px","color":"#333"}' class="icon iconfont icon-jiantou34" v-if="sortType!='price'"></span>
			<span :style='{"margin":"0 2px 0 0","lineHeight":"40px","fontSize":"14px","color":"#333"}' class="icon iconfont icon-jiantou35" v-else-if="sortType=='price'&&sortOrder=='desc'"></span>
			<span :style='{"margin":"0 2px 0 0","lineHeight":"40px","fontSize":"14px","color":"#333"}' class="icon iconfont icon-jiantou36" v-else-if="sortType=='price'&&sortOrder=='asc'"></span>
			<span :style='{"color":"#333","lineHeight":"40px","fontSize":"14px"}'>价格</span>
		</el-button>
	</div>
	<div class="list" :style='{"minHeight":"600px","width":"80%","padding":"0","margin":"0 0 0 20%","background":"#F6F6F6"}'>
		<!-- 样式一 -->
		<div class="list1 index-pv1" :style='{"width":"100%","padding":"0 0","flexWrap":"wrap","background":"#F6F6F6","display":"flex","height":"auto"}'>
			<div :style='{"border":"4px solid #fff","padding":"10px 20px","margin":"10px 5px","flexWrap":"wrap","background":"#fff","display":"flex","width":"32%","position":"relative","height":"auto"}' v-for="(item, index) in dataList" :key="index" @click.stop="toDetail(item)" class="list-item animation-box">
				<img @click.stop="imgPreView(item.cheliangzhaopian)" :style='{"width":"100%","objectFit":"cover","display":"block","height":"275px","order":"2"}' v-if="item.cheliangzhaopian && item.cheliangzhaopian.substr(0,4)=='http'" :src="item.cheliangzhaopian.split(',')[0]" class="image" />
				<img @click.stop="imgPreView(baseUrl + (item.cheliangzhaopian?item.cheliangzhaopian.split(',')[0]:''))" :style='{"width":"100%","objectFit":"cover","display":"block","height":"275px","order":"2"}' v-else :src="baseUrl + (item.cheliangzhaopian?item.cheliangzhaopian.split(',')[0]:'')" class="image" />
				<div v-if="item.price" :style='{"padding":"0 10px","color":"#fff","textAlign":"center","background":"#AD8936","width":"100%","lineHeight":"40px","fontSize":"14px","order":"3"}' class="price"><span :style='{"fontSize":"12px"}'>￥</span>{{item.price}}</div>
				<div :style='{"padding":"0 10px 10px","color":"#000000","textAlign":"center","width":"100%","lineHeight":"2","fontSize":"18px","fontWeight":"bold","order":"1"}' class="name ">{{item.banchechehao}}</div>
				<div :style='{"width":"50%","padding":"6px 0","textAlign":"center","order":"7"}'>
				  <span class="icon iconfont icon-shijian21" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#9E9E9E"}'></span>
				  <span class="text" :style='{"color":"#9E9E9E","lineHeight":"1.5","fontSize":"12px"}'>{{item.addtime}}</span>
				</div>
				<div :style='{"width":"50%","padding":"6px 10px","textAlign":"center","background":"#D8D8D8","display":"inline-block","order":"5"}'>
				  <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#fff"}'></span>
				  <span class="text" :style='{"color":"#fff","lineHeight":"1.5","fontSize":"12px"}'>{{item.storeupnum}}</span>
				</div>
			</div>
		</div>
		
	</div>

	
	<el-pagination
	  background
	  id="pagination"
	  class="pagination"
	  :pager-count="7"
	  :page-size="pageSize"
	  :page-sizes="pageSizes"
	  prev-text="<"
	  next-text=">"
	  :hide-on-single-page="true"
	  :layout='["prev","pager","next"].join()'
	  :total="total"
	  :style='{"width":"100%","padding":"0 16%","margin":"10px auto","whiteSpace":"nowrap","color":"#333","fontWeight":"500"}'
	  @current-change="curChange"
      @size-change="sizeChange"
	  @prev-click="prevClick"
	  @next-click="nextClick"
	></el-pagination>

  </div>
  <el-dialog title="预览图" :visible.sync="previewVisible" width="50%">
  	<img :src="previewImg" alt="" style="width: 100%;">
  </el-dialog>
</div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
		selectIndex2: 0,
		selectOptionsList: [],
	    layouts: '',
		swiperIndex: -1,
        baseUrl: '',
        breadcrumbItem: [
          {
            name: '班车信息'
          }
        ],
        formSearch: {
          banchechehao: '',
          shifazhandian: '',
          zhongdianzhandian: '',
          sijixingming: '',
          price: '',
        },
        fenlei: [],
		feileiColumn: '',
        dataList: [],
        total: 1,
        pageSize: 9,
		pageSizes: [10,20,30,50],
        totalPage: 1,
        curFenlei: '全部',
        isPlain: false,
        indexQueryCondition: '',
        timeRange: [],
		centerType:false,
		previewImg: '',
		previewVisible: false,
		sortType: 'id',
		sortOrder: 'desc',
      }
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
		this.baseUrl = this.$config.baseUrl;
      this.getFenlei();
      this.getList(1, '全部');
    },
    //方法集合
    methods: {
		selectClick2(row,index) {
			row.check = index
			if(index == -1){
				this.formSearch[row.tableName] = ''
			}else {
				this.formSearch[row.tableName] = row.list[index]
			}
			this.getList()
		},
		add(path) {
			let query = {}
			if(this.centerType){
				query.centerType = 1
			}
			this.$router.push({path: path,query:query});
		},
      getFenlei() {
		this.$http.get('bancishijian/list',{}).then(res => {
		  if (res.data.code == 0) {
		    this.fenlei = res.data.data.list
		  }
		});
		this.feileiColumn = 'bancishijian'
      },
      getList(page, fenlei, ref = '') {
		if(fenlei == '全部') this.swiperIndex = -1;
		for(let i=0;i<this.fenlei.length;i++) {
			if(fenlei == this.fenlei[i][this.feileiColumn]) {
				this.swiperIndex = i;
				break;
			}
		}
		if(fenlei){
			this.curFenlei = fenlei;
		}
        // if (this.curFenlei == '全部') {
        //   this.isPlain = false;
        // } else {
        //   this.isPlain = true;
        // }
        let params = {page, limit: this.pageSize};
        let searchWhere = {};
        if (this.formSearch.banchechehao != '') searchWhere.banchechehao = '%' + this.formSearch.banchechehao + '%';
        if (this.formSearch.shifazhandian != '') searchWhere.shifazhandian = '%' + this.formSearch.shifazhandian + '%';
        if (this.formSearch.zhongdianzhandian != '') searchWhere.zhongdianzhandian = '%' + this.formSearch.zhongdianzhandian + '%';
        if (this.formSearch.sijixingming != '') searchWhere.sijixingming = '%' + this.formSearch.sijixingming + '%';
        if(this.formSearch.pricestart!='' && this.formSearch.pricestart!=undefined ){
          searchWhere.pricestart = this.formSearch.pricestart
        }
        if(this.formSearch.priceend!='' && this.formSearch.priceend!=undefined){
          searchWhere.priceend = this.formSearch.priceend
        }
        if (this.curFenlei != '全部') searchWhere.bancishijian = this.curFenlei;
			let user = JSON.parse(localStorage.getItem('sessionForm'))
		if (this.sortType) searchWhere.sort = this.sortType
		if (this.sortOrder) searchWhere.order = this.sortOrder
        this.$http.get(`banchexinxi/${this.centerType?'page':'list'}`, {params: Object.assign(params, searchWhere)}).then(res => {
          if (res.data.code == 0) {
            this.dataList = res.data.data.list;
            this.total = Number(res.data.data.total);
            this.pageSize = Number(res.data.data.pageSize);
            this.totalPage = res.data.data.totalPage;
			
			this.pageSizes = [this.pageSize, this.pageSize*2, this.pageSize*3, this.pageSize*5];
          }
        });
      },
	  sortClick(type){
		  if(this.sortType==type){
			  if(this.sortOrder == 'desc'){
				  this.sortOrder = 'asc'
			  }else{
				  this.sortOrder = 'desc'
			  }
		  }else{
			  this.sortType = type
			  this.sortOrder = 'desc'
		  }
		  this.getList(1, '全部')
	  },
      curChange(page) {
        this.getList(page,this.curFenlei);
      },
      prevClick(page) {
        this.getList(page,this.curFenlei);
      },
      sizeChange(size){
        this.pageSize = size
        this.getList(1,this.curFenlei);
      },
      nextClick(page) {
        this.getList(page,this.curFenlei);
      },
	  imgPreView(url){
		  this.previewImg = url
		  this.previewVisible = true
	  },
      toDetail(item) {
		  let params = {
			  id: item.id
		  }
		  if(this.centerType){
			  params.centerType = 1
		  }
        this.$router.push({path: '/index/banchexinxiDetail', query: params});
      },
	btnAuth(tableName,key){
		if(this.centerType){
			return this.isBackAuth(tableName,key)
		}else{
			return this.isAuth(tableName,key)
		}
	},
	backClick() {
		this.$router.push({path: '/index/center'});
	},
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.list-preview .list-form-pv .el-input {
		width: auto;
	}

	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__separator {
		margin: 0 9px;
		color: #ccc;
		font-weight: 500;
	}
	
	.breadcrumb-preview .el-breadcrumb .item1 /deep/ .el-breadcrumb__inner a {
		color: #9E9E9E;
		display: inline-block;
	}
	
	.breadcrumb-preview .el-breadcrumb .item2 /deep/ .el-breadcrumb__inner a {
		color: #9E9E9E;
		display: inline-block;
	}
	
	.category-1 .item {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 10px 0 0;
		color: #999;
		background: #efefef;
		width: 72px;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-1 .item:hover {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 10px 0 0;
		color: #999;
		background: #000;
		width: 72px;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-1 .item.active {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 10px 0 0;
		color: #999;
		background: #000;
		width: 72px;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-2 .item {
		cursor: pointer;
		border: 1px solid #fff;
		border-radius: 4px;
		margin: 0 0 0 0;
		color: #9E9E9E;
		background: transparent;
		width: 100%;
		font-size: 14px;
		border-width: 0 0 1px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-2 .item:hover {
		cursor: pointer;
		border: 1px solid #D8D8D8;
		border-radius: 4px;
		margin: 0 0 0 0;
		color: #000;
		background: transparent;
		width: 100%;
		font-size: 14px;
		border-width: 0 0 1px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-2 .item.active {
		cursor: pointer;
		border: 1px solid #D8D8D8;
		border-radius: 4px;
		margin: 0 0 0 0;
		color: #000;
		background: transparent;
		width: 100%;
		font-size: 14px;
		border-width: 0 0 1px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-3 .item {
		cursor: pointer;
		border-radius: 0;
		padding: 5px 10px;
		margin: 0 0 0 0;
		color: #9E9E9E;
		background: transparent;
		display: flex;
		justify-content: flex-end;
		align-items: center;
		height: 46px;
	}
	
	.category-3 .item:hover {
		border-radius: 0;
		color: #000;
		background: transparent;
	}
	
	.category-3 .item.active {
		border-radius: 0;
		color: #000;
		background: transparent;
	}
	
	.list-form-pv .el-input /deep/ .el-input__inner {
		border: 0;
		border-radius: 60px;
		padding: 0 10px;
		margin: 0;
		outline: none;
		color: #333;
		width: 100%;
		font-size: 15px;
		line-height: 42px;
		height: 42px;
	}
	
	.list-form-pv .el-select /deep/ .el-input__inner {
	}
	
	.list-form-pv .el-date-editor /deep/ .el-input__inner {
		border: 0;
		border-radius: 60px;
		padding: 0 30px;
		margin: 0;
		outline: none;
		color: #333;
		width: 100%;
		font-size: 15px;
		line-height: 42px;
		height: 42px;
	}
	
	.list .index-pv1 .animation-box {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
		z-index: initial;
	}
	
	.list .index-pv1 .animation-box:hover {
		border: 4px solid #AD8936;
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
		-webkit-perspective: 1000px;
		perspective: 1000px;
		transition: 0.3s;
		z-index: 1;
	}
	
	.list .index-pv1 .animation-box img {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
	}
	
	.list .index-pv1 .animation-box img:hover {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
		-webkit-perspective: 1000px;
		perspective: 1000px;
		transition: 0.3s;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__total {
		margin: 0 10px 0 0;
		color: #666;
		font-weight: 400;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-prev {
		border: none;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #666;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-next {
		border: none;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #666;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-prev:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #C0C4CC;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-next:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #C0C4CC;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pager {
		padding: 0;
		margin: 0;
		display: inline-block;
		vertical-align: top;
	}
	
	#pagination.el-pagination /deep/ .el-pager .number {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #666;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #f4f4f5;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pager .number:hover {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #fff;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #AD8936;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pager .number.active {
		cursor: default;
		padding: 0 4px;
		margin: 0 5px;
		color: #FFF;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #AD8936;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes {
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input {
		margin: 0 5px;
		width: 100px;
		position: relative;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 25px 0 8px;
		color: #606266;
		display: inline-block;
		font-size: 13px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
		top: 0;
		position: absolute;
		right: 0;
		height: 100%;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
		cursor: pointer;
		color: #C0C4CC;
		width: 25px;
		font-size: 14px;
		line-height: 28px;
		text-align: center;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__jump {
		margin: 0 0 0 24px;
		color: #606266;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__jump .el-input {
		border-radius: 3px;
		padding: 0 2px;
		margin: 0 2px;
		display: inline-block;
		width: 50px;
		font-size: 14px;
		line-height: 18px;
		position: relative;
		text-align: center;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 3px;
		color: #606266;
		display: inline-block;
		font-size: 14px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}

	
	.select2 .list .item-body .item {
				border-radius: 4px;
				padding: 0 5px;
				color: #333;
				background: #f5f5f5;
				display: inline-block;
				font-size: 14px;
				line-height: 32px;
			}
	.select2 .list .item-body .item:hover {
				color: #fff;
				background: #AD8936;
			}
	.select2 .list .item-body .item.active {
				color: #fff;
				background: #AD8936;
				display: inline-block;
			}
</style>
