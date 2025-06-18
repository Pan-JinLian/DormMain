//import request from '../utils/request'

// 模拟数据
const mockBuildings = [
  { id: '1', name: '1号楼', type: 'male', address: '校园东区' },
  { id: '2', name: '2号楼', type: 'female', address: '校园西区' },
]

export const getBuildings = () => {
  return new Promise((resolve) => {
    setTimeout(() => resolve(mockBuildings), 500)
  })
}

export const addBuilding = (building) => {
  return new Promise((resolve) => {
    mockBuildings.push({ ...building, id: Date.now().toString() })
    setTimeout(() => resolve(), 500)
  })
}

export const updateBuilding = (id, building) => {
  return new Promise((resolve) => {
    const index = mockBuildings.findIndex((b) => b.id === id)
    if (index !== -1) {
      mockBuildings[index] = { ...building, id }
    }
    setTimeout(() => resolve(), 500)
  })
}

export const deleteBuilding = (id) => {
  return new Promise((resolve) => {
    const index = mockBuildings.findIndex((b) => b.id === id)
    if (index !== -1) {
      mockBuildings.splice(index, 1)
    }
    setTimeout(() => resolve(), 500)
  })
}
