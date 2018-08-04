export interface Deserializable<T> {
  deserialize(object: any): T;
}
