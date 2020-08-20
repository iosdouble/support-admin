import request from '@/utils/request'


export function uploadFile(data) {
  return request({
    url: '/logo/upload',
    method: 'post',
    data: data
  })
}
