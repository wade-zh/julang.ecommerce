/***
 * 标准消息解析类
 * @author HongWei
 * @type {{}}
 */
var standardMeg = {};

!function () {
   standardMeg.isStandard = function (source) {
      if(source == null) return false;
      if(source.code == null || source.message == null) return false;
      return true;
   }
   standardMeg.isSuccess = function (source) {
      if(!this.isStandard(source)) return false;
      if(source.code != 0) return false;
      return true;
   }
}()