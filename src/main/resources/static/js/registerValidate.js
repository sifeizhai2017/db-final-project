$(function () {
    $('.form-signin').formValidation({
        message: 'This value is not valid',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            userName: {message: '用户昵称不能为空', validators: {notEmpty: {message: '用户昵称不能为空'},}},
            userPassword: {validators: {notEmpty: {message: '密码不能为空'}, stringLength: {min: 6, message: '密码长度必须大于6位'},}},
            userAccount: {
                validators: {
                    notEmpty: {message: '账号不能为空'},
                    regexp: {regexp: /^[^\u4e00-\u9fa5]+$/, message: '账号中不能包含汉字'}
                }
            },
            userNumOfDevice: {
                validators: {
                    notEmpty: {message: '不能为空'},
                    digits: {message: '不是有效的设备数'},
                    greaterThan: {value: 0, message: '设备数必须在0~32767之间'},
                    lessThan: {value: 32767, message: '设备数必须在0~32767之间'}
                }
            }
        }
    })
});