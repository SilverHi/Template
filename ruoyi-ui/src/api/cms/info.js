import request from '@/utils/request'

// 查询VCD信息列表
export function listInfo(query) {
  return request({
    url: '/cms/info/list',
    method: 'get',
    params: query
  })
}

// 查询VCD信息详细
export function getInfo(vcdId) {
  return request({
    url: '/cms/info/' + vcdId,
    method: 'get'
  })
}

// 新增VCD信息
export function addInfo(data) {
  return request({
    url: '/cms/info',
    method: 'post',
    data: data
  })
}

// 修改VCD信息
export function updateInfo(data) {
  return request({
    url: '/cms/info',
    method: 'put',
    data: data
  })
}

// 删除VCD信息
export function delInfo(vcdId) {
  return request({
    url: '/cms/info/' + vcdId,
    method: 'delete'
  })
}
