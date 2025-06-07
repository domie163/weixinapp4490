<template>
  <div>
    <div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20220727/5c8b6a2aa5b4484cb1e90615f9c60954.png)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>

      <el-form :style='{"padding":"100px 50px","margin":"0","borderRadius":"10px","backgroundImage":"url(http://codegen.caihongy.cn/20220727/ef38081d06954a35bda8bd82e2c7d9f1.png)","width":"600px","backgroundSize":"100% 100%","height":"auto"}'>
        <div v-if="true" :style='{"margin":"0 0 30px 0","color":"#000","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"24px","fontWeight":"600","height":"auto"}' class="title-container">基于微信小程序的短文写作竞赛管理系统登录</div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"50%","margin":"0 auto 10px","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="false" class="lable" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>用户名：</div>
          <input :style='{"border":"0px solid rgba(64, 158, 255, 1)","padding":"0 10px","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3020)","color":"#333","outlineOffset":"4px","width":"100%","fontSize":"14px","height":"44px"}' placeholder="请输入用户名" name="username" type="text" v-model="rulesForm.username">
        </div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"50%","margin":"0 auto 10px","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="false" class="lable" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>密码：</div>
          <input :style='{"border":"0px solid rgba(64, 158, 255, 1)","padding":"0 10px","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3020)","color":"#333","outlineOffset":"4px","width":"100%","fontSize":"14px","height":"44px"}' placeholder="请输入密码" name="password" type="password" v-model="rulesForm.password">
        </div>
        <div :style='{"width":"80%","textAlign":"center","margin":"30px auto"}' v-if="roles.length>1" prop="loginInRole" class="list-type">
          <el-radio v-for="item in roles" v-bind:key="item.roleName" v-model="rulesForm.role" :label="item.roleName">{{item.roleName}}</el-radio>
        </div>
        <div :style='{"width":"80%","margin":"20px auto","alignItems":"center","flexDirection":"column","justifyContent":"center","display":"flex"}'>
          <el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0 24px","boxShadow":"0px 4px 10px 0px #CFD5F8","margin":"0 10px 5px","outline":"none","color":"rgba(0, 0, 0, 1)","borderRadius":"0","background":"rgba(255, 217, 176, 1)","width":"250px","fontSize":"18px","height":"50px"}' type="primary" @click="login()" class="loginInBt">登录</el-button>
          <el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0 24px","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3020)","margin":"2.5px 10px","outline":"none","color":"rgba(99, 99, 99, 1)","borderRadius":"0","background":"rgba(226, 226, 226, 1)","width":"250px","fontSize":"16px","height":"45px"}' type="primary" @click="register('fuzeren')" class="register">注册负责人</el-button>
          <el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0 24px","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3020)","margin":"2.5px 10px","outline":"none","color":"rgba(99, 99, 99, 1)","borderRadius":"0","background":"rgba(226, 226, 226, 1)","width":"250px","fontSize":"16px","height":"45px"}' type="primary" @click="register('pingwei')" class="register">注册评委</el-button>
        </div>
      </el-form>

    </div>
  </div>
</template>
<script>

import menu from "@/utils/menu";
export default {
  data() {
    return {
      baseUrl:this.$base.url,
      loginType: 1,
      rulesForm: {
        username: "",
        password: "",
        role: "",
        code: '',
      },
      menus: [],
      roles: [],
      tableName: "",
      codes: [{
        num: 1,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      },{
        num: 2,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      },{
        num: 3,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      },{
        num: 4,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      }],
    };
  },
  mounted() {
    let menus = menu.list();
    this.menus = menus;

    for (let i = 0; i < this.menus.length; i++) {
      if (this.menus[i].hasBackLogin=='是') {
        this.roles.push(this.menus[i])
      }
    }

  },
  created() {
    this.getRandCode()
  },
  destroyed() {
	    },
  components: {
  },
  methods: {

    //注册
    register(tableName){
		this.$storage.set("loginTable", tableName);
        this.$storage.set("pageFlag", "register");
		this.$router.push({path:'/register'})
    },
    // 登陆
    login() {

		if (!this.rulesForm.username) {
			this.$message.error("请输入用户名");
			return;
		}
		if (!this.rulesForm.password) {
			this.$message.error("请输入密码");
			return;
		}
		if(this.roles.length>1) {
			if (!this.rulesForm.role) {
				this.$message.error("请选择角色");
				return;
			}

			let menus = this.menus;
			for (let i = 0; i < menus.length; i++) {
				if (menus[i].roleName == this.rulesForm.role) {
					this.tableName = menus[i].tableName;
				}
			}
		} else {
			this.tableName = this.roles[0].tableName;
			this.rulesForm.role = this.roles[0].roleName;
		}

		this.$http({
			url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
			method: "post"
		}).then(({ data }) => {
			if (data && data.code === 0) {
				this.$storage.set("Token", data.token);
				this.$storage.set("role", this.rulesForm.role);
				this.$storage.set("sessionTable", this.tableName);
				this.$storage.set("adminName", this.rulesForm.username);
				this.$router.replace({ path: "/index/" });
			} else {
				this.$message.error(data.msg);
			}
		});
    },
    getRandCode(len = 4){
		this.randomString(len)
    },
    randomString(len = 4) {
      let chars = [
          "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
          "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
          "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G",
          "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
          "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2",
          "3", "4", "5", "6", "7", "8", "9"
      ]
      let colors = ["0", "1", "2","3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"]
      let sizes = ['14', '15', '16', '17', '18']

      let output = [];
      for (let i = 0; i < len; i++) {
        // 随机验证码
        let key = Math.floor(Math.random()*chars.length)
        this.codes[i].num = chars[key]
        // 随机验证码颜色
        let code = '#'
        for (let j = 0; j < 6; j++) {
          let key = Math.floor(Math.random()*colors.length)
          code += colors[key]
        }
        this.codes[i].color = code
        // 随机验证码方向
        let rotate = Math.floor(Math.random()*60)
        let plus = Math.floor(Math.random()*2)
        if(plus == 1) rotate = '-'+rotate
        this.codes[i].rotate = 'rotate('+rotate+'deg)'
        // 随机验证码字体大小
        let size = Math.floor(Math.random()*sizes.length)
        this.codes[i].size = sizes[size]+'px'
      }
    },
  }
};
</script>

<style lang="scss" scoped>
.container {
  min-height: 100vh;
  position: relative;
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
      background: url(http://codegen.caihongy.cn/20220727/5c8b6a2aa5b4484cb1e90615f9c60954.png);
        
  .list-item /deep/ .el-input .el-input__inner {
		border: 0px solid rgba(64, 158, 255, 1);
		padding: 0 10px;
		box-shadow: 0px 4px 10px 0px rgba(0,0,0,0.3020);
		color: #333;
		width: 100%;
		font-size: 14px;
		outline-offset: 4px;
		height: 44px;
	  }
  
  .list-code /deep/ .el-input .el-input__inner {
  	  	border: 0px solid rgba(64, 158, 255, 1);
  	  	border-radius: 0;
  	  	padding: 0 10px;
  	  	box-shadow: 0px 4px 10px 0px rgba(0,0,0,0.3020);
  	  	outline: none;
  	  	color: #333;
  	  	width: 100%;
  	  	font-size: 14px;
  	  	height: 44px;
  	  }

  .list-type /deep/ .el-radio__input .el-radio__inner {
		background: rgba(53, 53, 53, 0);
		border-color: #666666;
	  }
  .list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
        background: rgba(254, 91, 12, 1);
        border-color: rgba(254, 91, 12, 1);
      }
  .list-type /deep/ .el-radio__label {
		color: #666666;
		font-size: 14px;
	  }
  .list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
        color: rgba(254, 91, 12, 1);
        font-size: 14px;
      }
}
</style>
