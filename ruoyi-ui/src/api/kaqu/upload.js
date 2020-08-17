import request from '@/utils/request'


export function uploadFile(data) {
  return request({
    url: '/kaqu/upload',
    method: 'post',
    data: data
  })
}
