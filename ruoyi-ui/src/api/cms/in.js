import request from '@/utils/request'

// 查询入库管理列表
export function listIn(query) {
  return request({
    url: '/cms/in/list',
    method: 'get',
    params: query
  })
}

// 查询入库管理详细
export function getIn(inId) {
  return request({
    url: '/cms/in/' + inId,
    method: 'get'
  })
}

// 新增入库管理
export function addIn(data) {
  return request({
    url: '/cms/in',
    method: 'post',
    data: data
  })
}

// 修改入库管理
export function updateIn(data) {
  return request({
    url: '/cms/in',
    method: 'put',
    data: data
  })
}

// 删除入库管理
export function delIn(inId) {
  return request({
    url: '/cms/in/' + inId,
    method: 'delete'
  })
}
