<template>
	<div>
		<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20220727/404e0e98502c43b39dd6d72f6f8fdb8f.png)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
			<el-form v-if="pageFlag=='register'" :style='{"padding":"70px 20px","margin":"0","borderRadius":"10px","backgroundImage":"url(http://codegen.caihongy.cn/20220727/ef38081d06954a35bda8bd82e2c7d9f1.png)","width":"550px","backgroundSize":"100% 100% ","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm">
				<div v-if="true" :style='{"margin":"0 0 30px 0","color":"#000","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"24px","fontWeight":"600","height":"auto"}' class="title">基于微信小程序的短文写作竞赛管理系统注册</div>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='fuzeren'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">负责人账号</div>
					<el-input  v-model="ruleForm.fuzerenzhanghao"  autocomplete="off" placeholder="负责人账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='fuzeren'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">负责人姓名</div>
					<el-input  v-model="ruleForm.fuzerenxingming"  autocomplete="off" placeholder="负责人姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='fuzeren'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">密码</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='fuzeren'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">确认密码</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='fuzeren'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">性别</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in fuzerenxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='fuzeren'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">手机号</div>
					<el-input  v-model="ruleForm.shoujihao"  autocomplete="off" placeholder="手机号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='fuzeren'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">头像</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="fuzerentouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='youke'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">游客账号</div>
					<el-input  v-model="ruleForm.youkezhanghao"  autocomplete="off" placeholder="游客账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='youke'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">游客姓名</div>
					<el-input  v-model="ruleForm.youkexingming"  autocomplete="off" placeholder="游客姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='youke'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">密码</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='youke'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">确认密码</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='youke'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">性别</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in youkexingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='youke'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">手机</div>
					<el-input  v-model="ruleForm.shouji"  autocomplete="off" placeholder="手机"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='youke'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">头像</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="youketouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">学生学号</div>
					<el-input  v-model="ruleForm.xueshengxuehao"  autocomplete="off" placeholder="学生学号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">学生姓名</div>
					<el-input  v-model="ruleForm.xueshengxingming"  autocomplete="off" placeholder="学生姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">密码</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">确认密码</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">性别</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in xueshengxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">专业</div>
                    <el-select v-model="ruleForm.zhuanye" placeholder="请选择专业" >
                        <el-option
                            v-for="(item,index) in xueshengzhuanyeOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">班级</div>
                    <el-select v-model="ruleForm.banji" placeholder="请选择班级" >
                        <el-option
                            v-for="(item,index) in xueshengbanjiOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">手机</div>
					<el-input  v-model="ruleForm.shouji"  autocomplete="off" placeholder="手机"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">邮箱</div>
					<el-input  v-model="ruleForm.youxiang"  autocomplete="off" placeholder="邮箱"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">头像</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="xueshengtouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='pingwei'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">评委账号</div>
					<el-input  v-model="ruleForm.pingweizhanghao"  autocomplete="off" placeholder="评委账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='pingwei'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">评委姓名</div>
					<el-input  v-model="ruleForm.pingweixingming"  autocomplete="off" placeholder="评委姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='pingwei'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">密码</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='pingwei'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">确认密码</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='pingwei'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">性别</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in pingweixingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='pingwei'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">联系方式</div>
					<el-input  v-model="ruleForm.lianxifangshi"  autocomplete="off" placeholder="联系方式"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='pingwei'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">头像</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="pingweitouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"20px auto 15px","outline":"none","color":"#333","borderRadius":"0","background":"rgba(255, 217, 176, 1)","display":"block","width":"80%","fontSize":"18px","height":"50px"}' type="button" class="r-btn" @click="login()">注册</button>
				<div :style='{"cursor":"pointer","padding":"0 10%","color":"#333","textAlign":"center","display":"inline-block","width":"100%","lineHeight":"1","fontSize":"12px","textDecoration":"underline"}' class="r-login" @click="close()">已有账号，直接登录</div>
			</el-form>
			
		</div>
	</div>
</template>

<script>

export default {
	data() {
		return {
			ruleForm: {
                xingbie: '',
                xingbie: '',
                xingbie: '',
                zhuanye: '',
                banji: '',
                xingbie: '',
			},

            pageFlag : '',
			tableName:"",
			rules: {},
            fuzerenxingbieOptions: [],
            youkexingbieOptions: [],
            xueshengxingbieOptions: [],
            xueshengzhuanyeOptions: [],
            xueshengbanjiOptions: [],
            pingweixingbieOptions: [],
		};
	},
	mounted(){
        this.pageFlag = this.$storage.get("pageFlag");
		let table = this.$storage.get("loginTable");
		this.tableName = table;
        this.fuzerenxingbieOptions = "男,女".split(',')
        this.youkexingbieOptions = "男,女".split(',')
        this.xueshengxingbieOptions = "男,女".split(',')
        this.$http({
            url: `option/zhuanye/zhuanye`,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code === 0) {
                this.xueshengzhuanyeOptions = data.data;
            } else {
                this.$message.error(data.msg);
            }
        });
        this.$http({
            url: `option/banji/banji`,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code === 0) {
                this.xueshengbanjiOptions = data.data;
            } else {
                this.$message.error(data.msg);
            }
        });
        this.pingweixingbieOptions = "男,女".split(',')
	},
	created() {
    
	},
	destroyed() {
		  	},
	methods: {
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        fuzerentouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        youketouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        xueshengtouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        pingweitouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
					if((!this.ruleForm.fuzerenzhanghao) && `fuzeren` == this.tableName){
						this.$message.error(`负责人账号不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.fuzerenxingming) && `fuzeren` == this.tableName){
						this.$message.error(`负责人姓名不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.mima) && `fuzeren` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `fuzeren` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`fuzeren` == this.tableName && this.ruleForm.shoujihao&&(!this.$validate.isMobile(this.ruleForm.shoujihao))){
						this.$message.error(`手机号应输入手机格式`);
						return
					}
					
					
					
					
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					
					
					
					
					
					
					
					
					
					
				
					if((!this.ruleForm.youkezhanghao) && `youke` == this.tableName){
						this.$message.error(`游客账号不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.youkexingming) && `youke` == this.tableName){
						this.$message.error(`游客姓名不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.mima) && `youke` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `youke` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`youke` == this.tableName && this.ruleForm.shouji&&(!this.$validate.isMobile(this.ruleForm.shouji))){
						this.$message.error(`手机应输入手机格式`);
						return
					}
					
					
					
					
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					
					
					
					
					
					
					
					
					
					
				
					if((!this.ruleForm.xueshengxuehao) && `xuesheng` == this.tableName){
						this.$message.error(`学生学号不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.xueshengxingming) && `xuesheng` == this.tableName){
						this.$message.error(`学生姓名不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.mima) && `xuesheng` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `xuesheng` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`xuesheng` == this.tableName && this.ruleForm.shouji&&(!this.$validate.isMobile(this.ruleForm.shouji))){
						this.$message.error(`手机应输入手机格式`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					if(`xuesheng` == this.tableName && this.ruleForm.youxiang&&(!this.$validate.isEmail(this.ruleForm.youxiang))){
						this.$message.error(`邮箱应输入邮件格式`);
						return
					}
					
					
					
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					
					
					
					
					
					
					
					
					
					
				
					if((!this.ruleForm.pingweizhanghao) && `pingwei` == this.tableName){
						this.$message.error(`评委账号不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.pingweixingming) && `pingwei` == this.tableName){
						this.$message.error(`评委姓名不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.mima) && `pingwei` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `pingwei` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`pingwei` == this.tableName && this.ruleForm.lianxifangshi&&(!this.$validate.isMobile(this.ruleForm.lianxifangshi))){
						this.$message.error(`联系方式应输入手机格式`);
						return
					}
					
					
					
					
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					
					
					
					
					
					
					
					
					
					
				
			
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
	.container {
	  position: relative;
	  background: url(http://codegen.caihongy.cn/20220727/404e0e98502c43b39dd6d72f6f8fdb8f.png);

		.el-date-editor.el-input {
		  width: 100%;
		}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border: 0;
						border-radius: 0;
						padding: 0 10px;
						box-shadow: 0px 4px 10px 0px rgba(0,0,0,0.3020);
						outline: none;
						color: rgba(64, 158, 255, 1);
						width: 100%;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border: 0;
						border-radius: 0;
						padding: 0 10px;
						box-shadow: 0px 4px 10px 0px rgba(0,0,0,0.3020);
						outline: none;
						color: #333;
						width: 305px;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 0;
						border-radius: 0;
						padding: 0 10px 0 30px;
						box-shadow: 0px 4px 10px 0px rgba(0,0,0,0.3020);
						outline: none;
						color: #333;
						width: 100%;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 0;
						border-radius: 0;
						padding: 0 10px 0 30px;
						box-shadow: 0px 4px 10px 0px rgba(0,0,0,0.3020);
						outline: none;
						color: #333;
						width: 100%;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  border: 1px dashed rgba(0,0,0,0.3020);
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: rgba(0,0,0,0.3020);
		  		  width: 80px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 1px dashed rgba(0,0,0,0.3020);
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: rgba(0,0,0,0.3020);
		  		  width: 80px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 1px dashed rgba(0,0,0,0.3020);
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: rgba(0,0,0,0.3020);
		  		  width: 80px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
	}
</style>
