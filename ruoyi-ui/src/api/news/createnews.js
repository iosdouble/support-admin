import request from '@/utils/request'
import da from "element-ui/src/locale/lang/da";
// 创建新闻内容
export function createNews(data) {
  return request({
    url: '/news/create',
    method: 'post',
    data: data
  })
}

export function listNews() {
  return request({
    url: '/news/getAll',
    method: 'get'
  })
}


