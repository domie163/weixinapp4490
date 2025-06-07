<template>
  <div :style='{"padding":"30px 50px"}'>
    <el-form
	  :style='{"padding":"30px","boxShadow":"0 1px 6px #8aa4bd","borderRadius":"6px","background":"rgba(255, 255, 255, 0.9)"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      label-width="140px"
    >  
     <el-row>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='fuzeren'"  label="负责人账号" prop="fuzerenzhanghao">
          <el-input v-model="ruleForm.fuzerenzhanghao" readonly              placeholder="负责人账号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='fuzeren'"  label="负责人姓名" prop="fuzerenxingming">
          <el-input v-model="ruleForm.fuzerenxingming"               placeholder="负责人姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='fuzeren'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in fuzerenxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='fuzeren'"  label="手机号" prop="shoujihao">
          <el-input v-model="ruleForm.shoujihao"               placeholder="手机号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='fuzeren'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="fuzerentouxiangUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='youke'"  label="游客账号" prop="youkezhanghao">
          <el-input v-model="ruleForm.youkezhanghao" readonly              placeholder="游客账号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='youke'"  label="游客姓名" prop="youkexingming">
          <el-input v-model="ruleForm.youkexingming"               placeholder="游客姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='youke'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in youkexingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='youke'"  label="手机" prop="shouji">
          <el-input v-model="ruleForm.shouji"               placeholder="手机" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='youke'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="youketouxiangUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='xuesheng'"  label="学生学号" prop="xueshengxuehao">
          <el-input v-model="ruleForm.xueshengxuehao" readonly              placeholder="学生学号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='xuesheng'"  label="学生姓名" prop="xueshengxingming">
          <el-input v-model="ruleForm.xueshengxingming"               placeholder="学生姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='xuesheng'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in xueshengxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='xuesheng'"  label="专业" prop="zhuanye">
          <el-select v-model="ruleForm.zhuanye"  placeholder="请选择专业">
            <el-option
                v-for="(item,index) in xueshengzhuanyeOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='xuesheng'"  label="班级" prop="banji">
          <el-select v-model="ruleForm.banji"  placeholder="请选择班级">
            <el-option
                v-for="(item,index) in xueshengbanjiOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='xuesheng'"  label="手机" prop="shouji">
          <el-input v-model="ruleForm.shouji"               placeholder="手机" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='xuesheng'"  label="邮箱" prop="youxiang">
          <el-input v-model="ruleForm.youxiang"               placeholder="邮箱" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='xuesheng'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="xueshengtouxiangUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='pingwei'"  label="评委账号" prop="pingweizhanghao">
          <el-input v-model="ruleForm.pingweizhanghao" readonly              placeholder="评委账号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='pingwei'"  label="评委姓名" prop="pingweixingming">
          <el-input v-model="ruleForm.pingweixingming"               placeholder="评委姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='pingwei'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in pingweixingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='pingwei'"  label="联系方式" prop="lianxifangshi">
          <el-input v-model="ruleForm.lianxifangshi"               placeholder="联系方式" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='pingwei'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="pingweitouxiangUploadChange"
          ></file-upload>
        </el-form-item>
		<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='users'" label="用户名" prop="username">
			<el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
		</el-form-item>
		<el-form-item :style='{"padding":"0","margin":"0"}'>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#f5b688","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="onUpdateHandler">修 改</el-button>
		</el-form-item>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      fuzerenxingbieOptions: [],
      youkexingbieOptions: [],
      xueshengxingbieOptions: [],
      xueshengzhuanyeOptions: [],
      xueshengbanjiOptions: [],
      pingweixingbieOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
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
  methods: {
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
    onUpdateHandler() {
      if((!this.ruleForm.fuzerenzhanghao)&& 'fuzeren'==this.flag){
        this.$message.error('负责人账号不能为空');
        return
      }
      if((!this.ruleForm.fuzerenxingming)&& 'fuzeren'==this.flag){
        this.$message.error('负责人姓名不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'fuzeren'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if( 'fuzeren' ==this.flag && this.ruleForm.shoujihao&&(!isMobile(this.ruleForm.shoujihao))){
        this.$message.error(`手机号应输入手机格式`);
        return
      }
        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }
      if((!this.ruleForm.youkezhanghao)&& 'youke'==this.flag){
        this.$message.error('游客账号不能为空');
        return
      }
      if((!this.ruleForm.youkexingming)&& 'youke'==this.flag){
        this.$message.error('游客姓名不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'youke'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if( 'youke' ==this.flag && this.ruleForm.shouji&&(!isMobile(this.ruleForm.shouji))){
        this.$message.error(`手机应输入手机格式`);
        return
      }
        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }
      if((!this.ruleForm.xueshengxuehao)&& 'xuesheng'==this.flag){
        this.$message.error('学生学号不能为空');
        return
      }
      if((!this.ruleForm.xueshengxingming)&& 'xuesheng'==this.flag){
        this.$message.error('学生姓名不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'xuesheng'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if( 'xuesheng' ==this.flag && this.ruleForm.shouji&&(!isMobile(this.ruleForm.shouji))){
        this.$message.error(`手机应输入手机格式`);
        return
      }
      if( 'xuesheng' ==this.flag && this.ruleForm.youxiang&&(!isEmail(this.ruleForm.youxiang))){
        this.$message.error(`邮箱应输入邮箱格式`);
        return
      }
        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }
      if((!this.ruleForm.pingweizhanghao)&& 'pingwei'==this.flag){
        this.$message.error('评委账号不能为空');
        return
      }
      if((!this.ruleForm.pingweixingming)&& 'pingwei'==this.flag){
        this.$message.error('评委姓名不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'pingwei'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if( 'pingwei' ==this.flag && this.ruleForm.lianxifangshi&&(!isMobile(this.ruleForm.lianxifangshi))){
        this.$message.error(`联系方式应输入手机格式`);
        return
      }
        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
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
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #333;
	  	  font-weight: 500;
	  	  width: 140px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 140px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 300px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  outline: none;
	  	  color: #333;
	  	  width: auto;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  outline: none;
	  	  color: #333;
	  	  width: auto;
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
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 2px solid #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 2px solid #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  min-height: 120px;
	  	  height: auto;
	  	}
</style>
