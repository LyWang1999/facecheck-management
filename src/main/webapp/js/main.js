function saveGift() {
            var form=new FormData($('#gift')[0]);
            console.log(form);
          $.ajax({
              type:'POST',
              url: 'https://www.duliu12.xin:8443/back/savegift',
              contentType: false,
              processData: false,
              data:form,
              success: function (data) {
              	console.log(data);
                  if(data.code==10000)
                      layui.use('layer', function () {
                          var layer = layui.layer;
                          layer.msg('操作成功');
                      });
              },
              fail: function (data) {
                  layui.use('layer', function () {
                      var layer = layui.layer;
                      layer.msg('操作失败');
                  });
              }
          })

}
