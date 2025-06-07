<template>
<view class="content">
	<view class="box" :style='{"minHeight":"100vh","padding":"0px 0 0px","borderColor":"#21d5ae","background":"#fff","borderWidth":"0px 0 0","width":"100%","position":"relative","borderStyle":"dashed","height":"auto"}'>
		<view :style='{"width":"100%","padding":"60rpx 40rpx","background":"none","display":"block","height":"auto"}'>
			<view :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='fuzeren'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}'>负责人账号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' disabled="true"  v-model="ruleForm.fuzerenzhanghao" placeholder="负责人账号"></input>
			</view>
			<view :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='fuzeren'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}'>负责人姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'   v-model="ruleForm.fuzerenxingming" placeholder="负责人姓名"></input>
			</view>
			<view :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='fuzeren'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}'>密码</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'  type="password" v-model="ruleForm.mima" placeholder="密码"></input>
			</view>
			<view v-if="tableName=='fuzeren'" :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">性别</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}'  @change="fuzerenxingbieChange" :value="fuzerenxingbieIndex" :range="fuzerenxingbieOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#666"}' class="uni-input picker-select-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
				</picker>
			</view>
			<view :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='fuzeren'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}'>手机号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'   v-model="ruleForm.shoujihao" placeholder="手机号"></input>
			</view>
			<view :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='fuzeren'" @tap="fuzerentouxiangTap" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}'>头像</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" style="margin: 0;" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-else class="avator" style="margin: 0;" src="../../static/gen/upload.png" mode=""></image>
			</view>
			<view :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='youke'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}'>游客账号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' disabled="true"  v-model="ruleForm.youkezhanghao" placeholder="游客账号"></input>
			</view>
			<view :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='youke'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}'>游客姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'   v-model="ruleForm.youkexingming" placeholder="游客姓名"></input>
			</view>
			<view :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='youke'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}'>密码</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'  type="password" v-model="ruleForm.mima" placeholder="密码"></input>
			</view>
			<view v-if="tableName=='youke'" :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">性别</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}'  @change="youkexingbieChange" :value="youkexingbieIndex" :range="youkexingbieOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#666"}' class="uni-input picker-select-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
				</picker>
			</view>
			<view :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='youke'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}'>手机</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'   v-model="ruleForm.shouji" placeholder="手机"></input>
			</view>
			<view :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='youke'" @tap="youketouxiangTap" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}'>头像</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" style="margin: 0;" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-else class="avator" style="margin: 0;" src="../../static/gen/upload.png" mode=""></image>
			</view>
			<view :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='xuesheng'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}'>学生学号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' disabled="true"  v-model="ruleForm.xueshengxuehao" placeholder="学生学号"></input>
			</view>
			<view :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='xuesheng'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}'>学生姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'   v-model="ruleForm.xueshengxingming" placeholder="学生姓名"></input>
			</view>
			<view :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='xuesheng'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}'>密码</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'  type="password" v-model="ruleForm.mima" placeholder="密码"></input>
			</view>
			<view v-if="tableName=='xuesheng'" :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">性别</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}'  @change="xueshengxingbieChange" :value="xueshengxingbieIndex" :range="xueshengxingbieOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#666"}' class="uni-input picker-select-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
				</picker>
			</view>
			<view v-if="tableName=='xuesheng'" :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">专业</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}'  @change="xueshengzhuanyeChange" :value="xueshengzhuanyeIndex" :range="xueshengzhuanyeOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#666"}' class="uni-input picker-select-input">{{ruleForm.zhuanye?ruleForm.zhuanye:"请选择专业"}}</view>
				</picker>
			</view>
			<view v-if="tableName=='xuesheng'" :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">班级</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}'  @change="xueshengbanjiChange" :value="xueshengbanjiIndex" :range="xueshengbanjiOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#666"}' class="uni-input picker-select-input">{{ruleForm.banji?ruleForm.banji:"请选择班级"}}</view>
				</picker>
			</view>
			<view :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='xuesheng'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}'>手机</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'   v-model="ruleForm.shouji" placeholder="手机"></input>
			</view>
			<view :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='xuesheng'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}'>邮箱</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'   v-model="ruleForm.youxiang" placeholder="邮箱"></input>
			</view>
			<view :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='xuesheng'" @tap="xueshengtouxiangTap" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}'>头像</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" style="margin: 0;" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-else class="avator" style="margin: 0;" src="../../static/gen/upload.png" mode=""></image>
			</view>
			<view :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='pingwei'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}'>评委账号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' disabled="true"  v-model="ruleForm.pingweizhanghao" placeholder="评委账号"></input>
			</view>
			<view :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='pingwei'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}'>评委姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'   v-model="ruleForm.pingweixingming" placeholder="评委姓名"></input>
			</view>
			<view :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='pingwei'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}'>密码</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'  type="password" v-model="ruleForm.mima" placeholder="密码"></input>
			</view>
			<view v-if="tableName=='pingwei'" :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">性别</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}'  @change="pingweixingbieChange" :value="pingweixingbieIndex" :range="pingweixingbieOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#666"}' class="uni-input picker-select-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
				</picker>
			</view>
			<view :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='pingwei'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}'>联系方式</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#666","borderRadius":"0px","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'   v-model="ruleForm.lianxifangshi" placeholder="联系方式"></input>
			</view>
			<view :style='{"minHeight":"100rpx","padding":"0 20rpx 2rpx","margin":"0 0 20rpx","borderColor":"#e1f9eb","alignItems":"center","borderRadius":"0px","borderWidth":"2rpx","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='pingwei'" @tap="pingweitouxiangTap" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","color":"#369555","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}'>头像</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" style="margin: 0;" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-else class="avator" style="margin: 0;" src="../../static/gen/upload.png" mode=""></image>
			</view>
			<view :style='{"padding":"0px","margin":"48rpx 0 0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"center","height":"auto"}' class="btn">
				<button @tap="update()" class="cu-btn lg" :style='{"padding":"0 40rpx","margin":"0 0px 40rpx","borderColor":"#d8f5e3","color":"#333","minWidth":"200rpx","borderRadius":"0px","background":"linear-gradient(180deg, rgba(255,255,255,1) 0%, rgba(226,247,234,1) 100%)","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx"}'>保存</button>
				<button @tap="logout()" class="cu-btn lg" :style='{"padding":"0 40rpx","boxShadow":"0px 0px 0px #ccc","margin":"0 0px 20rpx","borderColor":"#eee","color":"#333","minWidth":"200rpx","borderRadius":"0px","background":"linear-gradient(180deg, rgba(255,255,255,1) 0%, rgba(238,238,238,1) 100%)","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx"}'>退出登录</button>
			</view>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				ruleForm: {
				},
				tableName:"",
				fuzerenxingbieOptions: [],
				fuzerenxingbieIndex: 0,
				youkexingbieOptions: [],
				youkexingbieIndex: 0,
				xueshengxingbieOptions: [],
				xueshengxingbieIndex: 0,
				xueshengzhuanyeOptions: [],
				xueshengzhuanyeIndex: 0,
				xueshengbanjiOptions: [],
				xueshengbanjiIndex: 0,
				pingweixingbieOptions: [],
				pingweixingbieIndex: 0,
			}
		},
        components: {
            multipleSelect
        },
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
		async onLoad() {
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.ruleForm = res.data;
			this.tableName = table;
			// 自定义下拉框值
			if(this.tableName=='fuzeren'){
				this.fuzerenxingbieOptions = "男,女".split(',');
				this.fuzerenxingbieOptions.forEach((item, index) => {
					if(item==this.ruleForm.xingbie) {
						this.fuzerenxingbieIndex = index;
					}
				});
			}
			// 自定义下拉框值
			if(this.tableName=='youke'){
				this.youkexingbieOptions = "男,女".split(',');
				this.youkexingbieOptions.forEach((item, index) => {
					if(item==this.ruleForm.xingbie) {
						this.youkexingbieIndex = index;
					}
				});
			}
			// 自定义下拉框值
			if(this.tableName=='xuesheng'){
				this.xueshengxingbieOptions = "男,女".split(',');
				this.xueshengxingbieOptions.forEach((item, index) => {
					if(item==this.ruleForm.xingbie) {
						this.xueshengxingbieIndex = index;
					}
				});
			}
			// 下拉框
			if(this.tableName=='xuesheng'){
				res = await this.$api.option(`zhuanye`,`zhuanye`,{});
				this.xueshengzhuanyeOptions = res.data;
                this.xueshengzhuanyeOptions.unshift("请选择专业");
				this.xueshengzhuanyeOptions.forEach((item, index) => {
					if(item==this.ruleForm.zhuanye) {
						this.xueshengzhuanyeIndex = index;
					}
				});
			}
			// 下拉框
			if(this.tableName=='xuesheng'){
				res = await this.$api.option(`banji`,`banji`,{});
				this.xueshengbanjiOptions = res.data;
                this.xueshengbanjiOptions.unshift("请选择班级");
				this.xueshengbanjiOptions.forEach((item, index) => {
					if(item==this.ruleForm.banji) {
						this.xueshengbanjiIndex = index;
					}
				});
			}
			// 自定义下拉框值
			if(this.tableName=='pingwei'){
				this.pingweixingbieOptions = "男,女".split(',');
				this.pingweixingbieOptions.forEach((item, index) => {
					if(item==this.ruleForm.xingbie) {
						this.pingweixingbieIndex = index;
					}
				});
			}
			this.styleChange()
            this.$forceUpdate()
		},
		methods: {
            // 下拉变化
            fuzerenxingbieChange(e) {
                    this.fuzerenxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.fuzerenxingbieOptions[this.fuzerenxingbieIndex]
            },
			fuzerentouxiangTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
				});
			},
            // 下拉变化
            youkexingbieChange(e) {
                    this.youkexingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.youkexingbieOptions[this.youkexingbieIndex]
            },
			youketouxiangTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
				});
			},
            // 下拉变化
            xueshengxingbieChange(e) {
                    this.xueshengxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.xueshengxingbieOptions[this.xueshengxingbieIndex]
            },
            // 下拉变化
            xueshengzhuanyeChange(e) {
                    this.xueshengzhuanyeIndex = e.target.value
                    this.ruleForm.zhuanye = this.xueshengzhuanyeOptions[this.xueshengzhuanyeIndex]
            },
            // 下拉变化
            xueshengbanjiChange(e) {
                    this.xueshengbanjiIndex = e.target.value
                    this.ruleForm.banji = this.xueshengbanjiOptions[this.xueshengbanjiIndex]
            },
			xueshengtouxiangTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
				});
			},
            // 下拉变化
            pingweixingbieChange(e) {
                    this.pingweixingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.pingweixingbieOptions[this.pingweixingbieIndex]
            },
			pingweitouxiangTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
				});
			},

            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('. .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.userInfoForm.list.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			logout() {
				uni.setStorageSync('token', '');
				this.$utils.jump('../login/login');
			},
			// 注册
			async update() {
				if((!this.ruleForm.fuzerenzhanghao) && `fuzeren` == this.tableName){
					this.$utils.msg(`负责人账号不能为空`);
					return
				}
				if((!this.ruleForm.fuzerenxingming) && `fuzeren` == this.tableName){
					this.$utils.msg(`负责人姓名不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `fuzeren` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
				if(`fuzeren` == this.tableName && this.ruleForm.shoujihao&&(!this.$validate.isMobile(this.ruleForm.shoujihao))){
					this.$utils.msg(`手机号应输入手机格式`);
					return
				}
				if((!this.ruleForm.youkezhanghao) && `youke` == this.tableName){
					this.$utils.msg(`游客账号不能为空`);
					return
				}
				if((!this.ruleForm.youkexingming) && `youke` == this.tableName){
					this.$utils.msg(`游客姓名不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `youke` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
				if(`youke` == this.tableName && this.ruleForm.shouji&&(!this.$validate.isMobile(this.ruleForm.shouji))){
					this.$utils.msg(`手机应输入手机格式`);
					return
				}
				if((!this.ruleForm.xueshengxuehao) && `xuesheng` == this.tableName){
					this.$utils.msg(`学生学号不能为空`);
					return
				}
				if((!this.ruleForm.xueshengxingming) && `xuesheng` == this.tableName){
					this.$utils.msg(`学生姓名不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `xuesheng` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
				if(`xuesheng` == this.tableName && this.ruleForm.shouji&&(!this.$validate.isMobile(this.ruleForm.shouji))){
					this.$utils.msg(`手机应输入手机格式`);
					return
				}
				if(`xuesheng` == this.tableName && this.ruleForm.youxiang&&(!this.$validate.isEmail(this.ruleForm.youxiang))){
					this.$utils.msg(`邮箱应输入邮件格式`);
					return
				}
				if((!this.ruleForm.pingweizhanghao) && `pingwei` == this.tableName){
					this.$utils.msg(`评委账号不能为空`);
					return
				}
				if((!this.ruleForm.pingweixingming) && `pingwei` == this.tableName){
					this.$utils.msg(`评委姓名不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `pingwei` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
				if(`pingwei` == this.tableName && this.ruleForm.lianxifangshi&&(!this.$validate.isMobile(this.ruleForm.lianxifangshi))){
					this.$utils.msg(`联系方式应输入手机格式`);
					return
				}
				let table = uni.getStorageSync("nowTable");
				await this.$api.update(table, this.ruleForm);
				this.$utils.msgBack('修改成功');;
			},

		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
