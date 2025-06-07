
<template>
<view>
<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
	<view class="content">
		<view class="container" :style='{"minHeight":"100vh","width":"100%","padding":"0px 0 132rpx","position":"relative","background":"url() fixed,#fff","height":"auto"}'>
						<swiper :style='{"border":"0px dotted #f7de91","padding":"0px ","margin":"40rpx auto","borderColor":"#f4e5e2","alignItems":"center","display":"flex","justifyContent":"center","borderRadius":"40rpx","background":"#fff","borderWidth":"0px","width":"calc(100% - 48rpx)","borderStyle":"solid","height":"480rpx"}' class="swiper" :indicator-dots='false' :autoplay='true' :circular='false' indicator-active-color='#000000' indicator-color='rgba(0, 0, 0, .3)' :duration='500' :interval='5000' :vertical='false'>
				<swiper-item :style='{"width":"100%","height":"100%"}' v-for="(swiper,index) in swiperList" :key="index">
					<image :style='{"width":"auto","margin":"0px auto","maxHeight":"100%","display":"block","height":"100%","maxWidth":"100%"}' mode="aspectFill" v-if="swiper.substring(0,4)=='http'" :src="swiper"></image>
					<image :style='{"width":"auto","margin":"0px auto","maxHeight":"100%","display":"block","height":"100%","maxWidth":"100%"}' mode="aspectFill" v-else :src="baseUrl+swiper"></image>
				</swiper-item>
			</swiper>
									            <view :style='{"padding":"0px 24rpx 24rpx","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}' class="detail-content">

				<view :style='{"padding":"2rpx 12rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="detail-list-item title">
					<view :style='{"padding":"8rpx 8rpx 0","color":"#369555","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","minWidth":"180rpx","fontWeight":"600"}' class="lable">竞赛名称：</view>
					<view :style='{"padding":"8rpx 8rpx 20rpx","margin":"0px 0 0","color":"#666","flex":"1","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}' class="text">{{detail.jingsaimingcheng}}</view>
				</view>

				<view class="detail-list-item" :style='{"padding":"2rpx 12rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"8rpx 8rpx 0","color":"#369555","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","minWidth":"180rpx","fontWeight":"600"}'>成果名称：</view>
					<view  class="text" :style='{"padding":"8rpx 8rpx 20rpx","margin":"0px 0 0","color":"#666","flex":"1","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}'>{{detail.chengguomingcheng}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"2rpx 12rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"8rpx 8rpx 0","color":"#369555","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","minWidth":"180rpx","fontWeight":"600"}'>成果类别：</view>
					<view  class="text" :style='{"padding":"8rpx 8rpx 20rpx","margin":"0px 0 0","color":"#666","flex":"1","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}'>{{detail.chengguoleibie}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"2rpx 12rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"8rpx 8rpx 0","color":"#369555","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","minWidth":"180rpx","fontWeight":"600"}'>年度：</view>
					<view  class="text" :style='{"padding":"8rpx 8rpx 20rpx","margin":"0px 0 0","color":"#666","flex":"1","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}'>{{detail.niandu}}</view>
				</view>
				<view :style='{"padding":"2rpx 12rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="detail-list-item" @tap="download(detail.fujian)" >
					<view class="lable" :style='{"padding":"8rpx 8rpx 0","color":"#369555","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","minWidth":"180rpx","fontWeight":"600"}'>附件：</view>
					<view class="text" :style='{"padding":"8rpx 8rpx 20rpx","margin":"0px 0 0","color":"#666","flex":"1","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}'>下载文件</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"2rpx 12rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"8rpx 8rpx 0","color":"#369555","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","minWidth":"180rpx","fontWeight":"600"}'>备注：</view>
					<view  class="text" :style='{"padding":"8rpx 8rpx 20rpx","margin":"0px 0 0","color":"#666","flex":"1","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}'>{{detail.beizhu}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"2rpx 12rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"8rpx 8rpx 0","color":"#369555","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","minWidth":"180rpx","fontWeight":"600"}'>提交时间：</view>
					<view  class="text" :style='{"padding":"8rpx 8rpx 20rpx","margin":"0px 0 0","color":"#666","flex":"1","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}'>{{detail.tijiaoshijian}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"2rpx 12rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"8rpx 8rpx 0","color":"#369555","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","minWidth":"180rpx","fontWeight":"600"}'>负责人账号：</view>
					<view  class="text" :style='{"padding":"8rpx 8rpx 20rpx","margin":"0px 0 0","color":"#666","flex":"1","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}'>{{detail.fuzerenzhanghao}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"2rpx 12rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"8rpx 8rpx 0","color":"#369555","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","minWidth":"180rpx","fontWeight":"600"}'>负责人姓名：</view>
					<view  class="text" :style='{"padding":"8rpx 8rpx 20rpx","margin":"0px 0 0","color":"#666","flex":"1","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}'>{{detail.fuzerenxingming}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"2rpx 12rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"8rpx 8rpx 0","color":"#369555","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","minWidth":"180rpx","fontWeight":"600"}'>学生学号：</view>
					<view  class="text" :style='{"padding":"8rpx 8rpx 20rpx","margin":"0px 0 0","color":"#666","flex":"1","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}'>{{detail.xueshengxuehao}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"2rpx 12rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"8rpx 8rpx 0","color":"#369555","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","minWidth":"180rpx","fontWeight":"600"}'>学生姓名：</view>
					<view  class="text" :style='{"padding":"8rpx 8rpx 20rpx","margin":"0px 0 0","color":"#666","flex":"1","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}'>{{detail.xueshengxingming}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"2rpx 12rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"8rpx 8rpx 0","color":"#369555","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","minWidth":"180rpx","fontWeight":"600"}'>专业：</view>
					<view  class="text" :style='{"padding":"8rpx 8rpx 20rpx","margin":"0px 0 0","color":"#666","flex":"1","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}'>{{detail.zhuanye}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"2rpx 12rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"8rpx 8rpx 0","color":"#369555","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","minWidth":"180rpx","fontWeight":"600"}'>班级：</view>
					<view  class="text" :style='{"padding":"8rpx 8rpx 20rpx","margin":"0px 0 0","color":"#666","flex":"1","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}'>{{detail.banji}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"2rpx 12rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"8rpx 8rpx 0","color":"#369555","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","minWidth":"180rpx","fontWeight":"600"}'>手机：</view>
					<view  class="text" :style='{"padding":"8rpx 8rpx 20rpx","margin":"0px 0 0","color":"#666","flex":"1","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}'>{{detail.shouji}}</view>
				</view>




				<view v-if="userid" class="detail-list-item" :style='{"padding":"2rpx 12rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"8rpx 8rpx 0","color":"#369555","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","minWidth":"180rpx","fontWeight":"600"}'>审核状态：</view>
					<view v-if="detail.sfsh=='是'" class="text" :style='{"padding":"8rpx 8rpx 20rpx","margin":"0px 0 0","color":"#666","flex":"1","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}'>通过</view>
					<view v-if="detail.sfsh=='否'" class="text" :style='{"padding":"8rpx 8rpx 20rpx","margin":"0px 0 0","color":"#666","flex":"1","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}'>不通过</view>
					<view v-if="detail.sfsh=='待审核'" class="text" :style='{"padding":"8rpx 8rpx 20rpx","margin":"0px 0 0","color":"#666","flex":"1","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}'>待审核</view>
				</view>
				<view v-if="userid" class="detail-list-item" :style='{"padding":"2rpx 12rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","borderRadius":"0px","flexWrap":"wrap","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"8rpx 8rpx 0","color":"#369555","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","minWidth":"180rpx","fontWeight":"600"}'>审核回复</view>
					<view class="text" :style='{"padding":"8rpx 8rpx 20rpx","margin":"0px 0 0","color":"#666","flex":"1","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}'>{{detail.shhf}}</view>
				</view>




				<view class="bottom-content bg-white tabbar border shop" :style='{"width":"100%","padding":"20rpx 0px","flexWrap":"wrap","background":"none","display":"flex","height":"auto"}'>

					<button :style='{"border":"0","padding":"0 20rpx","margin":"0","color":"rgb(255, 255, 255)","background":"rgb(255, 170, 51)","width":"auto","fontSize":"28rpx","height":"80rpx"}' v-if="userid&&isAuth('chengguoxiangqing','审核')" @tap="onSHTap">审核</button>
					<button :style='{"border":"0","padding":"0 20rpx","margin":"0","color":"rgb(255, 255, 255)","background":"rgb(255, 170, 51)","width":"auto","fontSize":"28rpx","height":"80rpx"}' v-if="!userid&&isAuthFront('chengguoxiangqing','审核')" @tap="onSHTap">审核</button>
				</view>
			</view>

			<!-- 确认完成弹窗 -->
			<uni-popup class="popup-content" ref="popup" type="center">
				<form class="popup-form" style="background: #fff;width: 300px;display: block;border-radius: 10px;padding: 20px;text-align: center;">
					<view class=" margin-top">
						<picker @change="sfshChange" :value="sfshIndex" :range="sfshOptions">
							<view class="uni-input">{{detail.sfsh?detail.sfsh:'选择审核结果'}}</view>
						</picker>
					</view>
					<view class="">
						<!-- <view class="title">审核回复</view> -->
						<textarea style="width: 200px;" v-model="detail.shhf" placeholder="审核回复"></textarea>
						<!-- <input v-model="douyinId" placeholder="审核回复" name="input"></input> -->
					</view>
					<view class="btn-content">
						<button style="margin: 0 10px" @tap="onCloseWinTap" class="cu-btn bg-cyan">取消</button>
						<button style="margin: 0 10px" @tap="onFinishTap" class="cu-btn bg-red">确认</button>
					</view>
				</form>
			</uni-popup>
		</view>
	</view>
</mescroll-uni>
</view>
</template>

<script>
	export default {
		data() {
			return {
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				id: '',
                userid: '',
				detail: {},
				swiperList: [],
				commentList: [],
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 3, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				user: {},
				sfshIndex: -1,
				sfshOptions: ['通过','不通过', '待审核'],
				count: 0,
				timer: null
			}
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(options) {
			this.id = options.id;
            if(options.userid) {
                this.userid = options.userid;
            }
			// 渲染数据
			this.init();
		},
        onUnload() {
            if(this.timer) {
                clearInterval(this.timer);
            }
        },
		async onShow(options) {
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
		},
		destroyed: function() {
			//window.clearInterval(this.inter);
		},
		methods: {
			// 支付
			onPayTap(){
				uni.setStorageSync('paytable','chengguoxiangqing');
				uni.setStorageSync('payObject',this.detail);
				this.$utils.jump('../pay-confirm/pay-confirm?type=1')
			},
            onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
                this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
            },
			// 跨表
			onAcrossTap(tableName,crossOptAudit,statusColumnName,tips,statusColumnValue){
				if(crossOptAudit=='是'&&this.detail.sfsh!='是') {
					this.$utils.msg("请审核通过后再操作");
					return
				}
				uni.setStorageSync('crossTable','chengguoxiangqing');
				uni.setStorageSync(`crossObj`, this.detail);
				uni.setStorageSync(`statusColumnName`, statusColumnName);
				uni.setStorageSync(`statusColumnValue`, statusColumnValue);
				uni.setStorageSync(`tips`, tips);
				if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
					var obj = uni.getStorageSync('crossObj');
					for (var o in obj){
						if(o==statusColumnName && obj[o]==statusColumnValue){
							this.$utils.msg(tips);
							return
						}
					}
				}
				this.$utils.jump(`../${tableName}/add-or-update?cross=true`);
			},
			// 获取详情
			async init(){
                if(this.timer) {
                    clearInterval(this.timer);
                }
				let res = await this.$api.info('chengguoxiangqing', this.id);
				this.detail = res.data;
				// 轮播图片
				this.swiperList = this.detail.tupian ? this.detail.tupian.split(",") : [];
			},

			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},

			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				mescroll.resetUpScroll()
			},

			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				mescroll.endSuccess(mescroll.size, this.hasNext);

            },



			onChatTap() {
				this.$utils.jump('../chat/chat')
			},
			// 下载
			download(url){
				let _this = this;
				url=_this.$base.url +  url;
				uni.downloadFile({
					url: url,
					success: (res) => {
						if (res.statusCode === 200) {
							_this.$utils.msg('下载成功');
							 window.open(url);
						}
					}
				});
			},
			//
			onCartTabTap() {
				this.$utils.tab('../shop-cart/shop-cart')
			},
			// 添加评论
			async onCommentTap() {
				this.$utils.jump(`../discusschengguoxiangqing/add-or-update?refid=${this.id}`)
			},
			onSHTap() {
				this.$refs.popup.open()
			},
			// 完成审核
			async onFinishTap() {
				if(!this.detail.sfsh){
					this.$utils.msg('请选择审核状态');
					return
				}
				if(!this.detail.shhf){
					this.$utils.msg('请填写审核回复');
					return
				}
				if(this.detail.sfsh=="通过"){
					this.detail.sfsh = '是'
				}
				if(this.detail.sfsh=="不通过"){
					this.detail.sfsh = '否'
				}
				if(this.detail.sfsh=="待审核"){
					this.detail.sfsh = '待审核'
				}
				await this.$api.update('chengguoxiangqing', this.detail);
				this.$utils.msg('审核成功');
				this.$refs.popup.close();
			},
			// 关闭窗口
			onCloseWinTap() {
				this.$refs.popup.close()
			},
			sfshChange(e){
				console.log(this.detail)
				this.sfshIndex = e.target.value
				this.detail.sfsh = this.sfshOptions[this.sfshIndex]
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	
	.seat-list {
		display: flex;
		align-items: center;
		flex-wrap: wrap;
		background: #FFFFFF;
		margin: 20upx;
		border-radius: 20upx;
		padding: 20upx;
		font-size: 30upx;
		.seat-item {
			width: 33.33%;
			display: flex;
			align-items: center;
			flex-direction: column;
			margin-bottom: 20upx;
	
			.seat-icon {
				width: 50upx;
				height: 50upx;
				margin-bottom: 10upx;
			}
		}
	}
	
	audio {
		display: flex;
		flex-direction: column;
	}
	
	.audio /deep/ .uni-audio-default {
		width: inherit;
	}
</style>
