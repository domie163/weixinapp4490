<template>
<view class="content">
	<view :style='{"minHeight":"100vh","padding":"0px 0 80rpx","borderColor":"#21d5ae","background":"#fff","borderWidth":"0px 0 0","width":"100%","position":"relative","borderStyle":"dashed","height":"auto"}'>
		<form :style='{"width":"100%","padding":"60rpx 40rpx","background":"none","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"0 20rpx 0px","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#369555","textAlign":"right","fontWeight":"600"}' class="title">竞赛编号</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"none","fontSize":"28rpx"}' :disabled="ro.jingsaibianhao" v-model="ruleForm.jingsaibianhao" placeholder="竞赛编号"></input>
			</view>
			<view :style='{"padding":"0 20rpx 0px","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#369555","textAlign":"right","fontWeight":"600"}' class="title">竞赛名称</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"none","fontSize":"28rpx"}' :disabled="ro.jingsaimingcheng" v-model="ruleForm.jingsaimingcheng" placeholder="竞赛名称"></input>
			</view>
			<view :style='{"padding":"0 20rpx 0px","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#369555","textAlign":"right","fontWeight":"600"}' class="title">竞赛类别</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"none","fontSize":"28rpx"}' :disabled="ro.jingsaileibie" v-model="ruleForm.jingsaileibie" placeholder="竞赛类别"></input>
			</view>
			<view :style='{"padding":"0 20rpx 0px","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"solid","height":"auto"}' class="" @tap="tupianTap">
				<view :style='{"width":"auto","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#369555","textAlign":"right","fontWeight":"600"}' class="title">图片</view>
				<image :style='{"width":"72rpx","margin":"12rpx 0","borderRadius":"100%","objectFit":"cover","display":"block","height":"72rpx"}' class="avator" v-if="ruleForm.tupian" :src="baseUrl+ruleForm.tupian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"72rpx","margin":"12rpx 0","borderRadius":"100%","objectFit":"cover","display":"block","height":"72rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"0 20rpx 0px","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#369555","textAlign":"right","fontWeight":"600"}' class="title">竞赛分数</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"none","fontSize":"28rpx"}' :disabled="ro.jingsaifenshu" v-model="ruleForm.jingsaifenshu" placeholder="竞赛分数"></input>
			</view>
			<view :style='{"padding":"0 20rpx 0px","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#369555","textAlign":"right","fontWeight":"600"}' class="title">评分备注</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"none","fontSize":"28rpx"}' :disabled="ro.pingfenbeizhu" v-model="ruleForm.pingfenbeizhu" placeholder="评分备注"></input>
			</view>
			<view :style='{"padding":"0 20rpx 0px","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#369555","textAlign":"right","fontWeight":"600"}' class="title">评分时间</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"none","fontSize":"28rpx"}' v-model="ruleForm.pingfenshijian" placeholder="评分时间" @tap="toggleTab('pingfenshijian')"></input>
			</view>
			<view :style='{"padding":"0 20rpx 0px","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#369555","textAlign":"right","fontWeight":"600"}' class="title">负责人账号</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"none","fontSize":"28rpx"}' :disabled="ro.fuzerenzhanghao" v-model="ruleForm.fuzerenzhanghao" placeholder="负责人账号"></input>
			</view>
			<view :style='{"padding":"0 20rpx 0px","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#369555","textAlign":"right","fontWeight":"600"}' class="title">负责人姓名</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"none","fontSize":"28rpx"}' :disabled="ro.fuzerenxingming" v-model="ruleForm.fuzerenxingming" placeholder="负责人姓名"></input>
			</view>
			<view :style='{"padding":"0 20rpx 0px","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#369555","textAlign":"right","fontWeight":"600"}' class="title">学生学号</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"none","fontSize":"28rpx"}' :disabled="ro.xueshengxuehao" v-model="ruleForm.xueshengxuehao" placeholder="学生学号"></input>
			</view>
			<view :style='{"padding":"0 20rpx 0px","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#369555","textAlign":"right","fontWeight":"600"}' class="title">学生姓名</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"none","fontSize":"28rpx"}' :disabled="ro.xueshengxingming" v-model="ruleForm.xueshengxingming" placeholder="学生姓名"></input>
			</view>
			<view :style='{"padding":"0 20rpx 0px","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#369555","textAlign":"right","fontWeight":"600"}' class="title">专业</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"none","fontSize":"28rpx"}' :disabled="ro.zhuanye" v-model="ruleForm.zhuanye" placeholder="专业"></input>
			</view>
			<view :style='{"padding":"0 20rpx 0px","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#369555","textAlign":"right","fontWeight":"600"}' class="title">班级</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"none","fontSize":"28rpx"}' :disabled="ro.banji" v-model="ruleForm.banji" placeholder="班级"></input>
			</view>
			<view :style='{"padding":"0 20rpx 0px","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#369555","textAlign":"right","fontWeight":"600"}' class="title">手机</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"none","fontSize":"28rpx"}' :disabled="ro.shouji" v-model="ruleForm.shouji" placeholder="手机"></input>
			</view>
			<view :style='{"padding":"0 20rpx 0px","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#369555","textAlign":"right","fontWeight":"600"}' class="title">评委账号</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"none","fontSize":"28rpx"}' :disabled="ro.pingweizhanghao" v-model="ruleForm.pingweizhanghao" placeholder="评委账号"></input>
			</view>
			<view :style='{"padding":"0 20rpx 0px","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#369555","textAlign":"right","fontWeight":"600"}' class="title">评委姓名</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"none","fontSize":"28rpx"}' :disabled="ro.pingweixingming" v-model="ruleForm.pingweixingming" placeholder="评委姓名"></input>
			</view>
			
			<!-- 否 -->
 

			
			
			<view :style='{"padding":"0px","margin":"40rpx 0 0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"center","height":"auto"}' class="btn" >
				<button :style='{"padding":"0 40rpx","boxShadow":"0px 0px 0px #ccc","margin":"0 0 40rpx","borderColor":"#d8f5e3","color":"#333","display":"inline","minWidth":"200rpx","borderRadius":"0px","background":"linear-gradient(180deg, rgba(255,255,255,1) 0%, rgba(226,247,234,1) 100%)","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"28rpx","borderStyle":"solid","fontWeight":"500","height":"88rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

		<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="pingfenshijianConfirm" ref="pingfenshijian" themeColor="#333333"></w-picker>
	</view>
</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
    import xiaEditor from '@/components/xia-editor/xia-editor';
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				cross:'',
				ruleForm: {
				jingsaibianhao: '',
				jingsaimingcheng: '',
				jingsaileibie: '',
				tupian: '',
				jingsaifenshu: '',
				pingfenbeizhu: '',
				pingfenshijian: '',
				fuzerenzhanghao: '',
				fuzerenxingming: '',
				xueshengxuehao: '',
				xueshengxingming: '',
				zhuanye: '',
				banji: '',
				shouji: '',
				pingweizhanghao: '',
				pingweixingming: '',
				},
				// 登录用户信息
				user: {},
                ro:{
                   jingsaibianhao : false,
                   jingsaimingcheng : false,
                   jingsaileibie : false,
                   tupian : false,
                   jingsaifenshu : false,
                   pingfenbeizhu : false,
                   pingfenshijian : false,
                   fuzerenzhanghao : false,
                   fuzerenxingming : false,
                   xueshengxuehao : false,
                   xueshengxingming : false,
                   zhuanye : false,
                   banji : false,
                   shouji : false,
                   pingweizhanghao : false,
                   pingweixingming : false,
                },
			}
		},
		components: {
			wPicker,
            xiaEditor,
            multipleSelect
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},



		},
		async onLoad(options) {
            this.ruleForm.pingfenshijian = this.$utils.getCurDateTime();

			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取
			this.ruleForm.pingweizhanghao = this.user.pingweizhanghao
			this.ro.pingweizhanghao = true;
			this.ruleForm.pingweixingming = this.user.pingweixingming
			this.ro.pingweixingming = true;



			// 如果有登录，获取登录后保存的userid
			this.ruleForm.userid = uni.getStorageSync("userid")
			if (options.refid) {
				// 如果上一级页面传递了refid，获取改refid数据信息
				this.ruleForm.refid = options.refid;
				this.ruleForm.nickname = uni.getStorageSync("nickname");
			}
			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				res = await this.$api.info(`jieguozhanshi`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='jingsaibianhao'){
					this.ruleForm.jingsaibianhao = obj[o];
					this.ro.jingsaibianhao = true;
					continue;
					}
					if(o=='jingsaimingcheng'){
					this.ruleForm.jingsaimingcheng = obj[o];
					this.ro.jingsaimingcheng = true;
					continue;
					}
					if(o=='jingsaileibie'){
					this.ruleForm.jingsaileibie = obj[o];
					this.ro.jingsaileibie = true;
					continue;
					}
					if(o=='tupian'){
					this.ruleForm.tupian = obj[o].split(",")[0];
					this.ro.tupian = true;
					continue;
					}
					if(o=='jingsaifenshu'){
					this.ruleForm.jingsaifenshu = obj[o];
					this.ro.jingsaifenshu = true;
					continue;
					}
					if(o=='pingfenbeizhu'){
					this.ruleForm.pingfenbeizhu = obj[o];
					this.ro.pingfenbeizhu = true;
					continue;
					}
					if(o=='pingfenshijian'){
					this.ruleForm.pingfenshijian = obj[o];
					this.ro.pingfenshijian = true;
					continue;
					}
					if(o=='fuzerenzhanghao'){
					this.ruleForm.fuzerenzhanghao = obj[o];
					this.ro.fuzerenzhanghao = true;
					continue;
					}
					if(o=='fuzerenxingming'){
					this.ruleForm.fuzerenxingming = obj[o];
					this.ro.fuzerenxingming = true;
					continue;
					}
					if(o=='xueshengxuehao'){
					this.ruleForm.xueshengxuehao = obj[o];
					this.ro.xueshengxuehao = true;
					continue;
					}
					if(o=='xueshengxingming'){
					this.ruleForm.xueshengxingming = obj[o];
					this.ro.xueshengxingming = true;
					continue;
					}
					if(o=='zhuanye'){
					this.ruleForm.zhuanye = obj[o];
					this.ro.zhuanye = true;
					continue;
					}
					if(o=='banji'){
					this.ruleForm.banji = obj[o];
					this.ro.banji = true;
					continue;
					}
					if(o=='shouji'){
					this.ruleForm.shouji = obj[o];
					this.ro.shouji = true;
					continue;
					}
					if(o=='pingweizhanghao'){
					this.ruleForm.pingweizhanghao = obj[o];
					this.ro.pingweizhanghao = true;
					continue;
					}
					if(o=='pingweixingming'){
					this.ruleForm.pingweixingming = obj[o];
					this.ro.pingweixingming = true;
					continue;
					}
				}
			}
			this.styleChange()
            this.$forceUpdate()
		},
		methods: {
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
					// })
				})
			},

			// 多级联动参数


			// 日长控件选择日期时间
			pingfenshijianConfirm(val) {
				console.log(val)
				this.ruleForm.pingfenshijian = val.result;
				this.$forceUpdate();
			},


			tupianTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.tupian = 'upload/' + res.file;
					_this.$forceUpdate();
					_this.$nextTick(()=>{
						_this.styleChange()
					})
				});
			},

			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {

































//跨表计算判断
				var obj;
				if(this.ruleForm.jingsaifenshu&&(!this.$validate.isNumber(this.ruleForm.jingsaifenshu))){
					this.$utils.msg(`竞赛分数应输入数字`);
					return
				}
				//更新跨表属性
			       var crossuserid;
			       var crossrefid;
			       var crossoptnum;
				if(this.cross){
					var statusColumnName = uni.getStorageSync('statusColumnName');
					var statusColumnValue = uni.getStorageSync('statusColumnValue');
					if(statusColumnName!='') {
                        if(!obj) {
						    obj = uni.getStorageSync('crossObj');
                        }
						if(!statusColumnName.startsWith("[")) {
							for (var o in obj){
								if(o==statusColumnName){
									obj[o] = statusColumnValue;
								}

							}
							var table = uni.getStorageSync('crossTable');
							await this.$api.update(`${table}`, obj);
						} else {
						       crossuserid=Number(uni.getStorageSync('userid'));
						       crossrefid=obj['id'];
						       crossoptnum=uni.getStorageSync('statusColumnName');
						       crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
						}
					}
				}
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid=crossuserid;
					this.ruleForm.crossrefid=crossrefid;
					let params = {
						page: 1,
						limit:10,
						crossuserid:crossuserid,
						crossrefid:crossrefid,
					}
					let res = await this.$api.list(`jieguozhanshi`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
						return false;
					} else {
                //跨表计算
						if(this.ruleForm.id){
							await this.$api.update(`jieguozhanshi`, this.ruleForm);
						}else{
							await this.$api.add(`jieguozhanshi`, this.ruleForm);
						}
						this.$utils.msgBack('提交成功');
					}
				} else {
                //跨表计算
					if(this.ruleForm.id){
						await this.$api.update(`jieguozhanshi`, this.ruleForm);
					}else{
						await this.$api.add(`jieguozhanshi`, this.ruleForm);
					}
					this.$utils.msgBack('提交成功');
				}
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			bindDateChange(e) {
				this.date = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				this.$refs[str].show();
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
