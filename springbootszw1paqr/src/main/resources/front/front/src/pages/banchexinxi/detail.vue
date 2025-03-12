<template>
<div>
	<div :style='{"border":"1px solid #D8D8D8","padding":"16px 20px 10px","margin":"65px auto 20px","borderRadius":"0","background":"transparent","borderWidth":"0 0 3px","width":"68%"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'》'" :style='{"fontSize":"14px","lineHeight":"1"}'>
			<el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
			<el-breadcrumb-item class="item2" v-for="(item, index) in breadcrumbItem" :key="index" to="/index/banchexinxi"><a>{{item.name}}</a></el-breadcrumb-item>
			<el-breadcrumb-item class="item3"><a href="javascript:void(0);">详情</a></el-breadcrumb-item>
		</el-breadcrumb>
	</div>
	<div :style='{"border":"1px solid #D8D8D8","padding":"16px 20px 10px","margin":"65px auto 20px","borderRadius":"0","background":"transparent","borderWidth":"0 0 3px","width":"68%"}'>
		<el-button size="mini" @click="backClick">返回</el-button>
	</div>
	<div class="detail-preview" :style='{"width":"68%","margin":"10px auto","position":"relative","alignItems":"flex-start","flexWrap":"wrap","display":"flex"}'>
		<div class="attr" :style='{"width":"58%","padding":"0","margin":"0 0 10px 2%","background":"#fff","display":"flex","order":"2"}'>

			<div class="info" :style='{"minHeight":"520px","padding":"10px 0 0","margin":"0 0 0 0","background":"#fff","flex":"1"}'>
				<div class="item" :style='{"padding":"10px 16px","margin":"0 0 10px 0","alignItems":"center","background":"transparent","justifyContent":"space-between","display":"flex"}'>
					<div :style='{"color":"#000","fontSize":"20px","fontWeight":"bold"}'>
                    {{detail.banchechehao}}
                    </div>
					<div @click="storeup(1)" v-show="!isStoreup" :style='{"border":"1px solid #AD8936","padding":"6px 16px","borderRadius":"60px","background":"#fff"}'><i v-if="true" :style='{"color":"#AD8936","fontSize":"14px"}' class="el-icon-star-off"></i><span :style='{"color":"#AD8936","fontSize":"14px"}'>点我收藏({{detail.storeupnum}})</span></div>
					<div @click="storeup(-1)" v-show="isStoreup" :style='{"border":"1px solid #AD8936","padding":"6px 16px","borderRadius":"60px","background":"#fff"}'><i v-if="true" :style='{"color":"#AD8936","fontSize":"14px"}' class="el-icon-star-on"></i><span :style='{"color":"#AD8936","fontSize":"14px"}'>取消收藏({{detail.storeupnum}})</span></div>
				</div>
				<div class="item" :style='{"padding":"4px 10px","margin":"0 0 6px 0","background":"transparent","justifyContent":"spaceBetween","display":"flex"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#000","textAlign":"left","width":"auto","fontSize":"15px","lineHeight":"40px","height":"40px"}'>限时秒杀</div>
					<count-down v-if="endTime&&startTime"
						:style='{"padding":"0 10px","fontSize":"15px","lineHeight":"40px","color":"#000","flex":"1","height":"40px"}'
						:startTime="startTime"
						:endTime="endTime"
						:tipText="'距离开始 '"
						tipTextEnd="距离结束 "
						endText="活动已结束"
						dayTxt="天 "
						hourTxt="小时 "
						minutesTxt="分钟 "
						secondsTxt="秒">
					</count-down>
				</div>
				<div class="item" :style='{"padding":"4px 10px","margin":"0 0 6px 0","background":"transparent","justifyContent":"spaceBetween","display":"flex"}' v-if="detail.price">
					<div class="lable" :style='{"padding":"0 10px","color":"#000","textAlign":"left","width":"auto","fontSize":"15px","lineHeight":"40px","height":"40px"}'>价格</div>
					<div style="font-weight: bold;" :style='{"padding":"0 10px","fontSize":"15px","lineHeight":"40px","color":"#000","flex":"1","height":"40px"}'><span :style='{"fontSize":"12px"}'>￥</span>{{detail.price}}</div>
				</div>
				<div class="item" :style='{"padding":"4px 10px","margin":"0 0 6px 0","background":"transparent","justifyContent":"spaceBetween","display":"flex"}' v-if="detail.jf">
					<div class="lable" :style='{"padding":"0 10px","color":"#000","textAlign":"left","width":"auto","fontSize":"15px","lineHeight":"40px","height":"40px"}'>积分</div>
					<div style="color: red;font-weight: bold;" :style='{"padding":"0 10px","fontSize":"15px","lineHeight":"40px","color":"#000","flex":"1","height":"40px"}'>{{detail.jf}}</div>
				</div>
				<div class="item" :style='{"padding":"4px 10px","margin":"0 0 6px 0","background":"transparent","justifyContent":"spaceBetween","display":"flex"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#000","textAlign":"left","width":"auto","fontSize":"15px","lineHeight":"40px","height":"40px"}'>车牌号码</div>
					<div  :style='{"padding":"0 10px","fontSize":"15px","lineHeight":"40px","color":"#000","flex":"1","height":"40px"}'>{{detail.chepaihaoma}}</div>
				</div>
				<div class="item" :style='{"padding":"4px 10px","margin":"0 0 6px 0","background":"transparent","justifyContent":"spaceBetween","display":"flex"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#000","textAlign":"left","width":"auto","fontSize":"15px","lineHeight":"40px","height":"40px"}'>班次时间</div>
					<div  :style='{"padding":"0 10px","fontSize":"15px","lineHeight":"40px","color":"#000","flex":"1","height":"40px"}'>{{detail.bancishijian}}</div>
				</div>
				<div class="item" :style='{"padding":"4px 10px","margin":"0 0 6px 0","background":"transparent","justifyContent":"spaceBetween","display":"flex"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#000","textAlign":"left","width":"auto","fontSize":"15px","lineHeight":"40px","height":"40px"}'>始发班次</div>
					<div  :style='{"padding":"0 10px","fontSize":"15px","lineHeight":"40px","color":"#000","flex":"1","height":"40px"}'>{{detail.shifabanci}}</div>
				</div>
				<div class="item" :style='{"padding":"4px 10px","margin":"0 0 6px 0","background":"transparent","justifyContent":"spaceBetween","display":"flex"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#000","textAlign":"left","width":"auto","fontSize":"15px","lineHeight":"40px","height":"40px"}'>末发班次</div>
					<div  :style='{"padding":"0 10px","fontSize":"15px","lineHeight":"40px","color":"#000","flex":"1","height":"40px"}'>{{detail.mofabanci}}</div>
				</div>
				<div class="item" :style='{"padding":"4px 10px","margin":"0 0 6px 0","background":"transparent","justifyContent":"spaceBetween","display":"flex"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#000","textAlign":"left","width":"auto","fontSize":"15px","lineHeight":"40px","height":"40px"}'>始发站点</div>
					<div  :style='{"padding":"0 10px","fontSize":"15px","lineHeight":"40px","color":"#000","flex":"1","height":"40px"}'>{{detail.shifazhandian}}</div>
				</div>
				<div class="item" :style='{"padding":"4px 10px","margin":"0 0 6px 0","background":"transparent","justifyContent":"spaceBetween","display":"flex"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#000","textAlign":"left","width":"auto","fontSize":"15px","lineHeight":"40px","height":"40px"}'>终点站点</div>
					<div  :style='{"padding":"0 10px","fontSize":"15px","lineHeight":"40px","color":"#000","flex":"1","height":"40px"}'>{{detail.zhongdianzhandian}}</div>
				</div>
				<div class="item" :style='{"padding":"4px 10px","margin":"0 0 6px 0","background":"transparent","justifyContent":"spaceBetween","display":"flex"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#000","textAlign":"left","width":"auto","fontSize":"15px","lineHeight":"40px","height":"40px"}'>司机姓名</div>
					<div  :style='{"padding":"0 10px","fontSize":"15px","lineHeight":"40px","color":"#000","flex":"1","height":"40px"}'>{{detail.sijixingming}}</div>
				</div>
				<div class="item" :style='{"padding":"4px 10px","margin":"0 0 6px 0","background":"transparent","justifyContent":"spaceBetween","display":"flex"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#000","textAlign":"left","width":"auto","fontSize":"15px","lineHeight":"40px","height":"40px"}'>班次状态</div>
					<div  :style='{"padding":"0 10px","fontSize":"15px","lineHeight":"40px","color":"#000","flex":"1","height":"40px"}'>{{detail.bancizhuangtai}}</div>
				</div>
				<div class="item" :style='{"padding":"4px 10px","margin":"0 0 6px 0","background":"transparent","justifyContent":"spaceBetween","display":"flex"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#000","textAlign":"left","width":"auto","fontSize":"15px","lineHeight":"40px","height":"40px"}'>座位总数</div>
					<div  :style='{"padding":"0 10px","fontSize":"15px","lineHeight":"40px","color":"#000","flex":"1","height":"40px"}'>{{detail.number}}</div>
				</div>
				<div class="btn" :style='{"padding":"10px 20px","flexWrap":"wrap","background":"#fff","display":"flex"}'>

					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#fff","borderRadius":"5px","background":"#000","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' type="warning" size="small" @click="bookClick">立即预订</el-button>
				</div>
				<div class="btn" :style='{"padding":"10px 20px","flexWrap":"wrap","background":"#fff","display":"flex"}'>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#fff","borderRadius":"5px","background":"#000","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="btnAuth('banchexinxi','修改')" @click="editClick">修改</el-button>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","color":"#fff","borderRadius":"5px","background":"#000","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="btnAuth('banchexinxi','删除')" @click="delClick">删除</el-button>
					<!-- hasChat 无 -->
				</div>
			</div>
		</div>
		
			<div class="swiper3" v-if="detailBanner.length" :style='{"margin":"0 0 80px","background":"transparent","display":"flex","width":"40%","justifyContent":"space-between","height":"400px","order":"1"}'>
			  <div class="big" :style='{"border":"none","padding":"16px","margin":"0 0 20px","background":"#fff","width":"78%","position":"relative","height":"400px"}'>
				<img id="big" :style='{"width":"100%","boxShadow":"none","objectFit":"cover","display":"block","height":"100%","zIndex":"1"}' :src="swiperBigUrl" class="image">
			  </div>
			  <div class="samll" :style='{"padding":"0","background":"transparent","flexDirection":"column","display":"flex","width":"18%","justifyContent":"space-between","height":"100%"}'>
			    <div :style='{"border":"none","width":"100%","margin":"0 0","position":"relative","background":"#fff","height":"85px"}' v-for="item in detailBanner" :key="item.id">
				  <img :style='{"width":"100%","boxShadow":"none","objectFit":"cover","display":"block","height":"100%","zIndex":"1"}' v-if="item.substr(0,4)=='http'" :src="item" @click="swiperClick3(item)" class="image">
				  <img :style='{"width":"100%","boxShadow":"none","objectFit":"cover","display":"block","height":"100%","zIndex":"1"}' v-else :src="baseUrl + item" @click="swiperClick3(baseUrl + item)" class="image">
			    </div>
			  </div>
			</div>


		

		
		<el-tabs class="detail" :style='{"border":"1px solid #E7E7E7","width":"100%","boxShadow":"none","margin":"30px 0","background":"#fff","order":"10"}' v-model="activeName" type="border-card">
																		<el-tab-pane label="交通路线" name="first">
				<div v-html="detail.jiaotongluxian"></div>
			</el-tab-pane>
															<el-tab-pane label="购票规则" name="first1">
				<div v-html="detail.goupiaoguize"></div>
			</el-tab-pane>
																<el-tab-pane label="评论" name="second">
				<el-form class="add comment" :style='{"boxShadow":"none","padding":"15px 15px 0","margin":"0 0 20px","flexWrap":"wrap","background":"#fff","display":"flex","position":"relative"}' :model="form" :rules="rules" ref="form">
					<el-form-item class="item" :style='{"width":"100%","margin":"0","flexWrap":"wrap","display":"flex","height":"auto"}' label="评论" prop="content">
						<editor
						    :style='{"border":"0","boxShadow":"none","outline":"none","margin":"0 0 20px","color":"#000","borderRadius":"4px","width":"100%","lineHeight":"32px","fontSize":"14px"}'
						    v-model="form.content" 
						    class="editor" 
						    action="file/upload">
						</editor>
					</el-form-item>
					<el-form-item class="btn" :style='{"padding":"0 0 0 80px","margin":"10px 0 0","bottom":"0","display":"flex","width":"50%","position":"absolute","right":"0","justifyContent":"flex-end","height":"auto"}'>
						<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"5px","background":"#AD8936","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="submitForm('form')">立即提交</el-button>
						<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"5px","background":"#000","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="resetForm('form')">重置</el-button>
					</el-form-item>
				</el-form>
				
				<div v-if="infoList.length" :style='{"boxShadow":"none","padding":"15px","background":"#f6f6f6"}' class="comment">
					<div :style='{"padding":"16px 20px","margin":"0 0 20px","borderColor":"#999","alignItems":"center","borderRadius":"10px","borderWidth":"0 0 0px 0","background":"#fff","width":"100%","borderStyle":"solid","height":"auto"}' v-for="item in infoList" :key="item.id" @mouseenter="discussEnter(item.id)"
						@mouseleave="discussLeave">
						<div class="user" :style='{"width":"100%","alignItems":"center","display":"flex","height":"auto"}'>
							<el-image v-if="item.avatarurl" :style='{"width":"30px","margin":"0 10px 0 0","borderRadius":"100%","objectFit":"cover","height":"30px"}' :size="50" :src="baseUrl + item.avatarurl"></el-image>
							<el-image v-if="!item.avatarurl" :style='{"width":"30px","margin":"0 10px 0 0","borderRadius":"100%","objectFit":"cover","height":"30px"}' :size="50" :src="require('@/assets/touxiang.png')"></el-image>
							<div :style='{"color":"#333","fontSize":"16px"}' class="name">{{item.nickname}}</div>
						</div>
						<div :style='{"padding":"8px","boxShadow":"none","margin":"10px 0px 0px","color":"#9E9E9E","borderRadius":"4px","background":"transparent","wordWrap":"break-word","lineHeight":"30px","fontSize":"14px"}' class="content-block-ask">
							<div v-html="item.content"></div>
							<div class="btn" :style='{"width":"100%","margin":"8px 0 0 0","alignItems":"center","justifyContent":"flex-end","display":"flex","height":"40px"}'>
							  <!-- <el-button :style='{"border":"0","cursor":"pointer","padding":"0 40px","margin":"0 10px","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"5px","background":"#1E3C4F","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}'>回复</el-button> -->
							  <el-button v-if="showIndex==item.id&&userid==item.userid" @click="discussDel(item.id)" :style='{"border":"1px solid #1E3C4F","cursor":"pointer","padding":"0 20px","margin":"0 10px","outline":"none","color":"#1E3C4F","borderRadius":"5px","background":"#fff","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}'>删除</el-button>
							</div>
						</div>
						<div :style='{"padding":"8px","boxShadow":"none","margin":"10px 0px 0px","color":"#9E9E9E","borderRadius":"4px","background":"transparent","wordWrap":"break-word","lineHeight":"30px","fontSize":"14px"}' class="content-block-reply" v-if="item.reply">
							回复：<span v-html="item.reply"></span>
						</div>
					</div>
				</div>
				
				<el-pagination
				  background
				  id="pagination" class="pagination"
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
				  @prev-click="prevClick"
				  @next-click="nextClick"
				></el-pagination>
			</el-tab-pane>
			<el-tab-pane label="选座" name="last">
				<div class="seat-list">
					<div v-for="(item, index) in numberList" v-bind:key="index" class="seat-item">
						<img @click="selectTip()" v-if="item.select" class="seat-icon" src="../../assets/selected.png" />
						<img @click="selectSeat(item)" v-else-if="!item.active" class="seat-icon" src="../../assets/unselect.png" />
						<img @click="unselectSeat(item)" v-else class="seat-icon" src="../../assets/select.png" />
						<span>{{item.name}}</span>
					</div>
				</div>
			</el-tab-pane>
		</el-tabs>
	</div>
	<div class="share_view" :style='{"boxShadow":"0 1px 6px rgba(0,0,0,.3)","position":"fixed","right":"0","bottom":"20%","background":"#fff","zIndex":"11"}'>
	</div>
</div>
</template>

<script>
  import CountDown from '@/components/CountDown';
  import axios from 'axios'
  import Swiper from "swiper";
  
  export default {
    //数据集合
    data() {
      return {
        tablename: 'banchexinxi',
        baseUrl: '',
        breadcrumbItem: [
          {
            name: '班车信息'
          }
        ],
        title: '',
        detailBanner: [],
		userid: localStorage.getItem('frontUserid'),
		startTime:0,
        endTime: 0,
		id: 0,
        detail: {},
        activeName: 'second',
        form: {
          content: '',
          userid: localStorage.getItem('frontUserid'),
          nickname: localStorage.getItem('username'),
          avatarurl: '',
        },
		showIndex: -1,
        infoList: [],
        rules: {
          content: [
            { required: true, message: '请输入内容', trigger: 'blur' }
          ],
        },
        total: 1,
        pageSize: 5,
		pageSizes: [10,20,30,50],
        totalPage: 1,
        storeupParams: {
          name: '',
          picture: '',
          refid: 0,
          tablename: 'banchexinxi',
          userid: localStorage.getItem('frontUserid')
        },
        isStoreup: false,
        storeupInfo: {},
        buynumber: 1,
        numberList: [],
		centerType: false,
		shareUrl: location.href,
		swiperBigUrl: null,
      }
    },
    created() {
		if(this.$route.query.centerType) {
			this.centerType = true
		}
		
        this.init();
    },
	mounted() {
	},
    //方法集合
    methods: {
		swiperClick3(src) {
			this.swiperBigUrl = src
		},
        init() {
		  this.id = this.$route.query.id
          this.baseUrl = this.$config.baseUrl;
          this.$http.get(this.tablename + '/detail/'  + this.id, {}).then(res => {
            if (res.data.code == 0) {
              this.detail = res.data.data;
              this.title = this.detail.banchechehao;
              this.detailBanner = this.detail.cheliangzhaopian ? this.detail.cheliangzhaopian.split(",") : [];
              this.startTime = new Date().getTime();
              this.endTime = new Date(this.detail.reversetime).getTime();
              this.$forceUpdate();

			  this.getDiscussList(1);
				if(localStorage.getItem('frontToken')){
					this.getStoreupStatus();
				}

			  let selectArray = this.detail.selected?this.detail.selected.split(','):[];
			  for (let i = 1; i <= this.detail.number; i++) {
				this.numberList.push({
				  name: `${i}号`,
				  select: false,
				  active: false
				});
			  }
			  if(selectArray.length){
				  for (let i = 0; i < selectArray.length; i++) {
					this.numberList[selectArray[i]-1].select = true;
				  }
			  }
          
            }
			if (this.detailBanner.length) {
				if (this.detailBanner[0].substr(0,4)=='http') {
					this.swiperBigUrl = this.detailBanner[0]
				} else {
					this.swiperBigUrl = this.baseUrl + this.detailBanner[0]
				}
			}
          });
        },
		createOrder() {
		  let order = '';
		  let now = new Date();
		  order += now.getFullYear();
		  order += now.getMonth() + 1;
		  order += now.getDate();
		  order += now.getHours();
		  order += now.getMinutes();
		  order += now.getSeconds();
		  order += now.getMilliseconds();
		  return order;
		},
		bookClick() {
            //倒计时
            if(new Date().getTime() > new Date(this.detail.reversetime).getTime()) {
              this.$message.error('活动已结束');
              return;
            }
            let activeSeat = [];
            for(let i=0;i<this.numberList.length;i++){
                if(this.numberList[i].active){
                    activeSeat.push(this.numberList[i].name.replace('号',''));
                }
            }
            if (activeSeat.length==0) {
                this.$message({
                  type: 'error',
                  message: '请选择要预定的位置!',
                  duration: 1500
                });
                return
            }
            let data = {
                orderid: this.createOrder(),
                tablename: this.tablename,
                userid: localStorage.getItem('frontUserid'),
                goodid: this.detail.id,
                goodname: this.title,
                picture:this.detailBanner[0],
                buynumber: activeSeat.length,
                total: 0,
                discounttotal: 0,
                address: activeSeat.join(','),
                activeSeat: activeSeat.join(','),
                status: '已支付',
                discountprice: this.detail.vipprice 
            }
            if (this.detail.price) {
                data['status'] = '未支付'
                data['price'] = this.detail.price
                data['total'] = parseFloat(data['price'] * activeSeat.length).toFixed(2)
                localStorage.setItem('orderGoods', JSON.stringify([data]));
                // 跳转到确认下单页面
                let query = {
                    type: 1,
                    seat: 1
                }
                this.$confirm('是否确认预定？')
                  .then(_ => {
                    this.$router.push({path: '/index/shop-order/orderConfirm', query: query});
                  }).catch(_ => {});
            } else {
                data['status'] = '已支付'
                data['price'] = 0
                data['total'] = parseFloat(data['price'] * activeSeat.length).toFixed(2)
                localStorage.setItem('orderGoods', JSON.stringify([data]));
                // 跳转到确认下单页面
                let query = {
                    type: 1,
                    seat: 1
                }
                this.$confirm('是否确认预定？')
                  .then(_ => {
                    this.$router.push({path: '/index/shop-order/orderConfirm', query: query});
                  }).catch(_ => {});
                //let oldSelectedArray = this.detail.selected?this.detail.selected.split(","):[];
                // 新的预定座位号
                //let newSelectArray = oldSelectedArray.concat(activeSeat);
                // 赋值给参数
                //  this.detail.selected = newSelectArray.join(',');
                //data['price'] = 0
                //layui.http.requestJson(`orders/add`, 'post', data, (res) => {
                    // 修改数据被选中座位信息
                 //   layui.http.requestJson(`${this.detailTable}/update`, 'post', this.detail, (res) => {
                  //      layer.msg(`预定成功`, {
                   //         time: 2000,
                    //        icon: 6
                     //   });
                    //});
                //})
            }
      },
      selectTip() {
        this.$message({
          type: 'error',
          message: '该座位已被预定!',
          duration: 1500
        });
      },
      selectSeat(item) {
        item.active = true;
      },
      unselectSeat(item) {
        item.active = false;
      },
      storeup(type) {
        if (type == 1 && !this.isStoreup) {
          this.storeupParams.name = this.title;
          this.storeupParams.picture = this.detailBanner[0];
          this.storeupParams.refid = this.detail.id;
          this.storeupParams.type = type;
          this.$http.post('storeup/add', this.storeupParams).then(res => {
            if (res.data.code == 0) {
              this.isStoreup = true;
			  this.detail.storeupnum++
			  this.$http.post('banchexinxi/update', this.detail).then(res => {});
              this.$message({
                type: 'success',
                message: '收藏成功!',
                duration: 1500,
              });
            }
          });
        }
        if (type == -1 && this.isStoreup) {
          this.$http.get('storeup/list', {params: {page: 1, limit: 1, type: 1, refid: this.detail.id, tablename: 'banchexinxi', userid: localStorage.getItem('frontUserid')}}).then(res => {
            if (res.data.code == 0 && res.data.data.list.length > 0) {
              this.isStoreup = true;
              this.storeupInfo = res.data.data.list[0];
              let delIds = new Array();
              delIds.push(this.storeupInfo.id);
              this.$http.post('storeup/delete', delIds).then(res => {
                if (res.data.code == 0) {
                  this.isStoreup = false;
				  this.detail.storeupnum--
				  this.$http.post('banchexinxi/update', this.detail).then(res => {});
                  this.$message({
                    type: 'success',
                    message: '取消成功!',
                    duration: 1500,
                  });
                }
              });
            }
          });
        }
      },
      getStoreupStatus(){
        if(localStorage.getItem("frontToken")) {
            this.$http.get('storeup/list', {params: {page: 1, limit: 1, type: 1, refid: this.detail.id, tablename: 'banchexinxi', userid: localStorage.getItem('frontUserid')}}).then(res => {
              if (res.data.code == 0 && res.data.data.list.length > 0) {
                this.isStoreup = true;
                this.storeupInfo = res.data.data.list[0];
              }
            });
        }
      },
      curChange(page) {
        this.getDiscussList(page);
      },
      prevClick(page) {
        this.getDiscussList(page);
      },
      nextClick(page) {
        this.getDiscussList(page);
      },
		// 返回按钮
		backClick(){
			history.back()
		},
		// 下载
		download(file){
			if(!file) {
				this.$message({
				  type: 'error',
				  message: '文件不存在',
				  duration: 1500,
				});
				return;
			}
		  let arr = file.replace(new RegExp('upload/', "g"), "")
		  axios.get(this.baseUrl + '/file/download?fileName=' + arr, {
		  	headers: {
		  		token: localStorage.getItem("frontToken")
		  	},
		  	responseType: "blob"
		  }).then(({
		  	data
		  }) => {
		  	const binaryData = [];
		  	binaryData.push(data);
		  	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
		  		type: 'application/pdf;chartset=UTF-8'
		  	}))
		  	const a = document.createElement('a')
		  	a.href = objectUrl
		  	a.download = arr
		  	// a.click()
		  	// 下面这个写法兼容火狐
		  	a.dispatchEvent(new MouseEvent('click', {
		  		bubbles: true,
		  		cancelable: true,
		  		view: window
		  	}))
		  	window.URL.revokeObjectURL(data)
		  },err=>{
			  axios.get((location.href.split(this.$config.name).length>1 ? location.href.split(this.$config.name)[0] :'') + this.$config.name + '/file/download?fileName=' + arr, {
			  	headers: {
			  		token: localStorage.getItem("frontToken")
			  	},
			  	responseType: "blob"
			  }).then(({
			  	data
			  }) => {
			  	const binaryData = [];
			  	binaryData.push(data);
			  	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
			  		type: 'application/pdf;chartset=UTF-8'
			  	}))
			  	const a = document.createElement('a')
			  	a.href = objectUrl
			  	a.download = arr
			  	// a.click()
			  	// 下面这个写法兼容火狐
			  	a.dispatchEvent(new MouseEvent('click', {
			  		bubbles: true,
			  		cancelable: true,
			  		view: window
			  	}))
			  	window.URL.revokeObjectURL(data)
			  })
		  })
      },
      getDiscussList(page) {
        this.$http.get('discussbanchexinxi/list', {params: {page, limit: this.pageSize, refid: this.detail.id}}).then(res => {
          if (res.data.code == 0) {
            this.infoList = res.data.data.list;
            this.total = res.data.data.total;
            this.pageSize = res.data.data.pageSize;this.pageSizes = [this.pageSize, this.pageSize*2, this.pageSize*3, this.pageSize*5];
            this.totalPage = res.data.data.totalPage;
          }
        });
      },
	  discussEnter(index){
		  this.showIndex = index
	  },
	  discussLeave(){
		  this.showIndex = -1
	  },
	  discussDel(id){
		  this.$confirm('是否删除此评论？')
		    .then(_ => {
		      this.$http.post('discussbanchexinxi/delete',[id]).then(res=>{
				  if(res.data&&res.data.code==0){
					  this.addDiscussNum(1)
					  this.$message({
					    type: 'success',
					    message: '删除成功!',
					    duration: 1500,
						onClose: () => {
							this.getDiscussList(1);
						}
					  });
				  }
			  })
		    }).catch(_ => {});
	  },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.get('orders/list', {params: {page: 1, limit: 1, status: '已完成', goodid: this.detail.id, userid: localStorage.getItem('frontUserid')}}).then(res => {
                if (res.data.code == 0 && res.data.data.list.length == 0) {
                  this.$message({
                    type: 'success',
                    message: '请完成订单后再评论!',
                    duration: 1500
                  });
                  return false
                } else {
                    this.form.refid = this.detail.id;
                    this.form.avatarurl = localStorage.getItem('frontHeadportrait')?localStorage.getItem('frontHeadportrait'):'';
                    this.$http.post('discussbanchexinxi/add', this.form).then(res => {
						if (res.data.code == 0) {
							this.addDiscussNum(2)
							this.form.content = '';
							this.getDiscussList(1);
							this.$message({
								type: 'success',
								message: '评论成功!',
								duration: 1500,
							});
						}
                    });
                }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
	  addDiscussNum(type){
		  if(type==2){
			  this.detail.discussnum++
		  }else if(type==1){
			  if(this.detail.discussnum!=0){
				  this.detail.discussnum--
			  }else{
				  this.detail.discussnum = 0
			  }
		  }
		  this.$http.post('banchexinxi/update',this.detail).then(res=>{
			  
		  })
	  },
        //立即购买
        buyNow() {
        if(new Date().getTime() > new Date(this.detail.reversetime).getTime()) {
          this.$message.error('活动已结束');
          return;
        }
            // 保存到storage中，在确认下单页面中获取要购买的商品
            localStorage.setItem('orderGoods', JSON.stringify([{
                tablename: this.tablename,
                goodid: this.detail.id,
                goodname: this.title,

                picture:this.detailBanner[0],
                buynumber: this.buynumber,
                userid: localStorage.getItem('frontUserid'),
                price: this.detail.price,
                discountprice: this.detail.vipprice ? this.detail.vipprice : 0
            }]));
            // 跳转到确认下单页面
            let query = {
                type: 1,
            }
            this.$router.push({path: '/index/shop-order/orderConfirm', query: query});
        },


		// 权限判断
		btnAuth(tableName,key){
			if(this.centerType){
				return this.isBackAuth(tableName,key)
			}else{
				return this.isAuth(tableName,key)
			}
		},
		// 修改
		editClick(){
			this.$router.push(`/index/banchexinxiAdd?type=edit&&id=${this.detail.id}`);
		},
		// 删除
		delClick(){
			this.$confirm('是否删除此班车信息？')
			  .then(_ => {
			    this.$http.post('banchexinxi/delete', [this.detail.id]).then(res => {
			      if (res.data.code == 0) {
			        this.$message({
			          type: 'success',
			          message: '删除成功!',
			          duration: 1500,
					  onClose: () => {
						  history.back()
					  }
			        });
			      }
			    });
			  }).catch(_ => {});
		},
    },
    components: {
      CountDown
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.editor /deep/ .avatar-uploader {
		height: 0;
		line-height: 0;
	}
	
	.detail-preview {
	
	  .attr {
	    .el-carousel /deep/ .el-carousel__indicator button {
	      width: 0;
	      height: 0;
	      display: none;
	    }
	
	    .el-input-number__decrease:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled), .el-input-number__increase:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled) {
	      border-color: none;
	    }
	  }
	
	  .detail {
	    & /deep/ .el-tabs__header .el-tabs__nav-wrap {
	      margin-bottom: 0;
	    }
	
	    & .add .el-textarea {
	      width: auto;
	    }
	  }
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
		background: red;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
		background: red;
	}

	.attr .el-carousel /deep/ .el-carousel__indicators {
		padding: 0;
		margin: 0;
		z-index: 2;
		position: absolute;
		list-style: none;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.4;
		transition: 0.3s;
		height: 12px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li:hover {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 0.7;
		height: 12px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li.is-active {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 1;
		height: 12px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__decrease {
		cursor: pointer;
		z-index: 1;
		display: flex;
		border-color: #DCDFE6;
		border-radius: 4px 0 0 4px;
		top: 1px;
		left: 1px;
		background: #fff;
		width: 40px;
		justify-content: center;
		border-width: 0 1px 0 0;
		align-items: center;
		position: absolute;
		border-style: solid;
		text-align: center;
		height: 38px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__decrease i {
		color: #000;
		font-size: 14px;
	}

	.attr .el-input-number /deep/ .el-input-number__increase {
		cursor: pointer;
		z-index: 1;
		display: flex;
		border-color: #DCDFE6;
		right: 1px;
		border-radius: 0 4px 4px 0;
		top: 1px;
		background: #fff;
		width: 40px;
		justify-content: center;
		border-width: 0 0 0 1px;
		align-items: center;
		position: absolute;
		border-style: solid;
		text-align: center;
		height: 38px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__increase i {
		color: #000;
		font-size: 14px;
	}
	
	.attr .el-input-number /deep/ .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		border-radius: 4px;
		padding: 0 40px;
		outline: none;
		color: #000;
		background: #FFF;
		display: inline-block;
		width: 100%;
		font-size: 14px;
		line-height: 40px;
		text-align: center;
		height: 40px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header {
		margin: 0;
		background: #fff;
		border-color: #E7E7E7;
		border-width: 0 0 1px;
		border-style: solid;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item {
		border: 1px solid #E7E7E7;
		padding: 0 60px;
		margin: 0;
		color: #9E9E9E;
		font-weight: 500;
		display: inline-block;
		font-size: 14px;
		line-height: 40px;
		background: transparent;
		border-width: 0 1px 0 0;
		position: relative;
		list-style: none;
		height: 40px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
		border: 1px solid #E7E7E7;
		padding: 0 60px;
		color: #fff;
		background: #AD8936;
		border-width: 0 1px 0 0;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
		border: 1px solid #E7E7E7;
		padding: 0 60px;
		color: #fff;
		background: #AD8936;
		border-width: 0 1px 0 0;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__content {
		padding: 15px;
	}
	
	.detail-preview .detail.el-tabs .add /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #666;
		width: 80px;
		font-size: 14px;
		line-height: 40px;
		text-align: right;
	}
	
	.detail-preview .detail.el-tabs .add /deep/ .el-textarea__inner {
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
		
	.breadcrumb-preview .el-breadcrumb .item3 /deep/ .el-breadcrumb__inner a {
		color: #9E9E9E;
		display: inline-block;
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
    .seat-list{
        display: flex;
        align-items: center;
        flex-wrap: wrap;
        .seat-item{
            width: 20%;
            display: flex;
            flex-direction: column;
            align-items: center;
			img {
				width: 60px;
			}
            span{
                line-height: 3;
            }
        }
    }
	.share_view{
		position: fixed;
		right:0;
		bottom: 20%;
		background: #fff;
		box-shadow: 0 4px 6px rgba(0,0,0,.1);
		.share{
			width: 40px;
			height: 40px;
			display: flex;
			align-items: center;
			justify-content: center;
			border-bottom: 1px solid #eee;
			cursor: pointer;
		}
		.share:last-of-type{
			border:none;
		}
	}


	.detail-preview .el-rate /deep/ .el-rate__item {
				cursor: pointer;
				display: inline-block;
				vertical-align: middle;
				font-size: 0;
				position: relative;
			}
	
	.detail-preview .el-rate /deep/ .el-rate__item .el-rate__icon {
				margin: 0 3px;
				display: block;
				font-size: 18px;
				position: relative;
				transition: .3s;
			}
</style>
