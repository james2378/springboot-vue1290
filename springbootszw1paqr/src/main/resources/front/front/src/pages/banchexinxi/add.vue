<template>
<div :style='{"width":"68%","padding":"80px 0","margin":"10px auto","position":"relative","background":"transparent"}'>
    <el-form
	  :style='{"width":"100%","position":"relative","flexWrap":"wrap","display":"flex"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"transparent"}' label="班车车号" prop="banchechehao">
            <el-input v-model="ruleForm.banchechehao" 
                placeholder="班车车号" clearable :disabled=" false  ||ro.banchechehao"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"transparent"}' label="车牌号码" prop="chepaihaoma">
            <el-input v-model="ruleForm.chepaihaoma" 
                placeholder="车牌号码" clearable :disabled=" false  ||ro.chepaihaoma"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"transparent"}'  label="班次时间" prop="bancishijian">
            <el-select v-model="ruleForm.bancishijian" placeholder="请选择班次时间" :disabled=" false  ||ro.bancishijian" >
              <el-option
                  v-for="(item,index) in bancishijianOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"transparent"}' label="车辆照片" v-if="type!='cross' || (type=='cross' && !ro.cheliangzhaopian)" prop="cheliangzhaopian">
            <file-upload
            tip="点击上传车辆照片"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.cheliangzhaopian?ruleForm.cheliangzhaopian:''"
            @change="cheliangzhaopianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"transparent"}' class="upload" v-else label="车辆照片" prop="cheliangzhaopian">
                <img v-if="ruleForm.cheliangzhaopian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.cheliangzhaopian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.cheliangzhaopian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"transparent"}' label="始发班次" prop="shifabanci">
            <el-input v-model="ruleForm.shifabanci" 
                placeholder="始发班次" clearable :disabled=" false  ||ro.shifabanci"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"transparent"}' label="末发班次" prop="mofabanci">
            <el-input v-model="ruleForm.mofabanci" 
                placeholder="末发班次" clearable :disabled=" false  ||ro.mofabanci"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"transparent"}' label="始发站点" prop="shifazhandian">
            <el-input v-model="ruleForm.shifazhandian" 
                placeholder="始发站点" clearable :disabled=" false  ||ro.shifazhandian"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"transparent"}' label="终点站点" prop="zhongdianzhandian">
            <el-input v-model="ruleForm.zhongdianzhandian" 
                placeholder="终点站点" clearable :disabled=" false  ||ro.zhongdianzhandian"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"transparent"}' label="司机姓名" prop="sijixingming">
            <el-input v-model="ruleForm.sijixingming" 
                placeholder="司机姓名" clearable :disabled=" false  ||ro.sijixingming"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"transparent"}'  label="班次状态" prop="bancizhuangtai">
            <el-select v-model="ruleForm.bancizhuangtai" placeholder="请选择班次状态" :disabled=" false  ||ro.bancizhuangtai" >
              <el-option
                  v-for="(item,index) in bancizhuangtaiOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"transparent"}' label="倒计结束时间" prop="reversetime">
              <el-date-picker
				  :disabled=" false  ||ro.reversetime"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.reversetime" 
                  type="datetime"
                  placeholder="倒计结束时间">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"transparent"}' label="价格" prop="price">
			<el-input-number v-model="ruleForm.price" placeholder="价格" :readonly="ro.price"></el-input-number>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"transparent"}' label="座位总数" prop="number">
            <el-input v-model.number="ruleForm.number" 
                placeholder="座位总数" clearable :disabled=" false  ||ro.number"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"transparent"}' label="已选座位[用,号隔开]" prop="selected">
            <el-input
              type="textarea"
              :rows="8"
              placeholder="已选座位[用,号隔开]"
              v-model="ruleForm.selected">
            </el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"transparent"}' label="交通路线" prop="jiaotongluxian">
            <editor 
                :style='{"padding":"0","boxShadow":"0 0 0px rgba(75,223,201,.5)","margin":"0","borderColor":"#ccc","backgroundColor":"#fff","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.jiaotongluxian" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"transparent"}' label="购票规则" prop="goupiaoguize">
            <editor 
                :style='{"padding":"0","boxShadow":"0 0 0px rgba(75,223,201,.5)","margin":"0","borderColor":"#ccc","backgroundColor":"#fff","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.goupiaoguize" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"6px 30px","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#000","width":"auto","fontSize":"16px","height":"auto"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"6px 30px","margin":"0","outline":"none","color":"#fff","borderRadius":"4px","background":"#9E9E9E","width":"auto","fontSize":"16px","height":"auto"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
	  let self = this
      return {
        id: '',
        baseUrl: '',
        ro:{
				banchechehao : false,
				chepaihaoma : false,
				bancishijian : false,
				cheliangzhaopian : false,
				shifabanci : false,
				mofabanci : false,
				shifazhandian : false,
				zhongdianzhandian : false,
				sijixingming : false,
				jiaotongluxian : false,
				goupiaoguize : false,
				bancizhuangtai : false,
				reversetime : false,
				discussnum : false,
				price : false,
				storeupnum : false,
				number : false,
				selected : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          banchechehao: '',
          chepaihaoma: '',
          bancishijian: '',
          cheliangzhaopian: '',
          shifabanci: '',
          mofabanci: '',
          shifazhandian: '',
          zhongdianzhandian: '',
          sijixingming: '',
          jiaotongluxian: '',
          goupiaoguize: '',
          bancizhuangtai: '已发车' ,
          reversetime: '',
          discussnum: '',
          price: '',
          storeupnum: '',
          number: '',
          selected: '',
        },
        bancishijianOptions: [],
        bancizhuangtaiOptions: [],


        rules: {
          banchechehao: [
          ],
          chepaihaoma: [
          ],
          bancishijian: [
          ],
          cheliangzhaopian: [
          ],
          shifabanci: [
          ],
          mofabanci: [
          ],
          shifazhandian: [
          ],
          zhongdianzhandian: [
          ],
          sijixingming: [
          ],
          jiaotongluxian: [
          ],
          goupiaoguize: [
          ],
          bancizhuangtai: [
            { required: true, message: '班次状态不能为空', trigger: 'blur' },
          ],
          reversetime: [
          ],
          discussnum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          price: [
            { required: true, message: '价格不能为空', trigger: 'blur' },
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          storeupnum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          number: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          selected: [
          ],
        },
		centerType: false,
      };
    },
    computed: {



    },
    components: {
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='banchechehao'){
              this.ruleForm.banchechehao = obj[o];
              this.ro.banchechehao = true;
              continue;
            }
            if(o=='chepaihaoma'){
              this.ruleForm.chepaihaoma = obj[o];
              this.ro.chepaihaoma = true;
              continue;
            }
            if(o=='bancishijian'){
              this.ruleForm.bancishijian = obj[o];
              this.ro.bancishijian = true;
              continue;
            }
            if(o=='cheliangzhaopian'){
              this.ruleForm.cheliangzhaopian = obj[o].split(",")[0];
              this.ro.cheliangzhaopian = true;
              continue;
            }
            if(o=='shifabanci'){
              this.ruleForm.shifabanci = obj[o];
              this.ro.shifabanci = true;
              continue;
            }
            if(o=='mofabanci'){
              this.ruleForm.mofabanci = obj[o];
              this.ro.mofabanci = true;
              continue;
            }
            if(o=='shifazhandian'){
              this.ruleForm.shifazhandian = obj[o];
              this.ro.shifazhandian = true;
              continue;
            }
            if(o=='zhongdianzhandian'){
              this.ruleForm.zhongdianzhandian = obj[o];
              this.ro.zhongdianzhandian = true;
              continue;
            }
            if(o=='sijixingming'){
              this.ruleForm.sijixingming = obj[o];
              this.ro.sijixingming = true;
              continue;
            }
            if(o=='jiaotongluxian'){
              this.ruleForm.jiaotongluxian = obj[o];
              this.ro.jiaotongluxian = true;
              continue;
            }
            if(o=='goupiaoguize'){
              this.ruleForm.goupiaoguize = obj[o];
              this.ro.goupiaoguize = true;
              continue;
            }
            if(o=='bancizhuangtai'){
              this.ruleForm.bancizhuangtai = obj[o];
              this.ro.bancizhuangtai = true;
              continue;
            }
            if(o=='reversetime'){
              this.ruleForm.reversetime = obj[o];
              this.ro.reversetime = true;
              continue;
            }
            if(o=='discussnum'){
              this.ruleForm.discussnum = obj[o];
              this.ro.discussnum = true;
              continue;
            }
            if(o=='price'){
              this.ruleForm.price = obj[o];
              this.ro.price = true;
              continue;
            }
            if(o=='storeupnum'){
              this.ruleForm.storeupnum = obj[o];
              this.ro.storeupnum = true;
              continue;
            }
            if(o=='number'){
              this.ruleForm.number = obj[o];
              this.ro.number = true;
              continue;
            }
            if(o=='selected'){
              this.ruleForm.selected = obj[o];
              this.ro.selected = true;
              continue;
            }
          }
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
          }
        });
        this.$http.get('option/bancishijian/bancishijian', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.bancishijianOptions = res.data.data;
          }
        });
        this.bancizhuangtaiOptions = "已发车,已达终点".split(',')

		if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
			localStorage.removeItem('raffleType')
			setTimeout(() => {
				this.onSubmit()
			}, 300)
		}
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`banchexinxi/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

			if(this.ruleForm.price<0){
				this.$message.error("价格不能输入负数");
				return
			}
			//更新跨表属性
			var crossuserid;
			var crossrefid;
			var crossoptnum;
			this.$refs["ruleForm"].validate(valid => {
				if(valid) {
					if(this.type=='cross'){
						var statusColumnName = localStorage.getItem('statusColumnName');
						var statusColumnValue = localStorage.getItem('statusColumnValue');
						if(statusColumnName && statusColumnName!='') {
							var obj = JSON.parse(localStorage.getItem('crossObj'));
							if(!statusColumnName.startsWith("[")) {
								for (var o in obj){
									if(o==statusColumnName){
										obj[o] = statusColumnValue;
									}
								}
								var table = localStorage.getItem('crossTable');
								this.$http.post(table+'/update', obj).then(res => {});
							} else {
								crossuserid=Number(localStorage.getItem('frontUserid'));
								crossrefid=obj['id'];
								crossoptnum=localStorage.getItem('statusColumnName');
								crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
							}
						}
					}
					if(crossrefid && crossuserid) {
						this.ruleForm.crossuserid=crossuserid;
						this.ruleForm.crossrefid=crossrefid;
						var params = {
							page: 1,
							limit: 10,
							crossuserid:crossuserid,
							crossrefid:crossrefid,
						}
						this.$http.get('banchexinxi/list', {
							params: params
						}).then(res => {
							if(res.data.data.total>=crossoptnum) {
								this.$message({
									message: localStorage.getItem('tips'),
									type: 'error',
									duration: 1500,
								});
								return false;
							} else {
								// 跨表计算


								this.$http.post(`banchexinxi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
									if (res.data.code == 0) {
										this.$message({
											message: '操作成功',
											type: 'success',
											duration: 1500,
											onClose: () => {
												this.$router.go(-1);
											}
										});
									} else {
										this.$message({
											message: res.data.msg,
											type: 'error',
											duration: 1500
										});
									}
								});
							}
						});
					} else {


						this.$http.post(`banchexinxi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
							}
						});
					}
				}
			});
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		// 返回
		back() {
			this.$router.go(-1);
		},
      cheliangzhaopianUploadChange(fileUrls) {
          this.ruleForm.cheliangzhaopian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #000;
	  font-weight: 500;
	  width: 80px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 80px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 0;
	  border-radius: 0;
	  padding: 0 12px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  background: #fff;
	  width: 340px;
	  font-size: 14px;
	  height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  border: 0;
	  border-radius: 0;
	  padding: 0 12px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  background: #fff;
	  width: 340px;
	  font-size: 14px;
	  height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 0;
	  border-radius: 0;
	  padding: 0 10px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  background: #fff;
	  width: 340px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 0;
	  border-radius: 0;
	  padding: 0 10px 0 30px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  background: #fff;
	  width: 250px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  border: none;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #000;
	  background: #fff;
	  width: 120px;
	  font-size: 32px;
	  line-height: 80px;
	  text-align: center;
	  height: 80px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: none;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #000;
	  background: #fff;
	  width: 120px;
	  font-size: 32px;
	  line-height: 80px;
	  text-align: center;
	  height: 80px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: none;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #000;
	  background: #fff;
	  width: 120px;
	  font-size: 32px;
	  line-height: 80px;
	  text-align: center;
	  height: 80px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 0;
	  border-radius: 0;
	  padding: 12px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  background: #fff;
	  width: 400px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
