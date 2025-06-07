const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootr653y/",
            name: "springbootr653y",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootr653y/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于微信小程序的短文写作竞赛管理系统"
        } 
    }
}
export default base
